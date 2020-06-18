package com.ryl.countrylist.presentation.countrylist.adapter.base

/**
 * Created by Andrzej Ryl
 */
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ryl.countrylist.data.datasource.model.NetworkState
import com.ryl.countrylist.data.datasource.model.isSuccess

abstract class BasePagedListAdapter<BaseDataSourceModel>(
    itemDiffer: DiffUtil.ItemCallback<BaseDataSourceModel>
) : PagedListAdapter<BaseDataSourceModel, RecyclerView.ViewHolder>(itemDiffer) {

    abstract fun getItemViewHolder(
        parent: ViewGroup
    ): RecyclerView.ViewHolder

    abstract fun getNetworkStateItemViewHolder(
        parent: ViewGroup,
        retryClickedListener: OnRetryClickedListener?
    ): RecyclerView.ViewHolder

    open var networkState: NetworkState? = null
    var onRetryClickedListener: OnRetryClickedListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (ItemViewType.values()[viewType]) {
            ItemViewType.ITEM -> getItemViewHolder(parent)
            ItemViewType.NETWORK_STATE -> getNetworkStateItemViewHolder(
                parent,
                onRetryClickedListener
            )
        }

    override fun getItemViewType(position: Int): Int = when {
        !networkState.isSuccess() && position == itemCount - 1 -> ItemViewType.NETWORK_STATE.ordinal
        else -> ItemViewType.ITEM.ordinal
    }

    override fun getItemCount(): Int {
        val extraRow = if (networkState.isSuccess()) 0 else 1
        return super.getItemCount() + extraRow
    }

    fun updateNetworkState(newNetworkState: NetworkState?) {
        val previousState = this.networkState
        this.networkState = newNetworkState
        when {
            !previousState.isSuccess() && !newNetworkState.isSuccess() ->
                notifyItemChanged(itemCount - 1)
            !previousState.isSuccess() -> notifyItemRemoved(super.getItemCount())
            else -> notifyItemInserted(super.getItemCount())
        }
    }
}

enum class ItemViewType {
    ITEM, NETWORK_STATE
}

typealias OnDataClickListener<T> = (data: T) -> Unit
typealias OnRetryClickedListener = () -> Unit