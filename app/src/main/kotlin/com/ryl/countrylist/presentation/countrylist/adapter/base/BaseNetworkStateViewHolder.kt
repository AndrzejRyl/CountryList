package com.ryl.countrylist.presentation.countrylist.adapter.base

/**
 * Created by Andrzej Ryl
 */
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ryl.countrylist.R
import com.ryl.countrylist.data.datasource.model.NetworkState
import com.ryl.countrylist.utils.hide
import com.ryl.countrylist.utils.show
import kotlinx.android.synthetic.main.item_network_state.view.*

abstract class BaseNetworkStateViewHolder(
    parent: ViewGroup,
    layoutInflater: LayoutInflater,
    private val onRetryClickedListener: OnRetryClickedListener?
) : BasePagedViewHolder<NetworkState>(R.layout.item_network_state, parent, layoutInflater) {

    abstract val failureInfoResId: Int

    override fun bind(item: NetworkState?) {
        hideAllViews()
        setViews(item)
        setRetryClickListener()
    }

    private fun setViews(networkState: NetworkState?) = with(itemView) {
        listNetworkStateTitle.text = context.getString(failureInfoResId)
        when (networkState) {
            NetworkState.RUNNING -> showProgressBar()
            NetworkState.FAILED -> {
                showStateTitle()
                showRetryButton()
            }
            NetworkState.SUCCESS, null -> {
            }
        }
    }

    private fun hideAllViews() = itemView.run {
        listNetworkStateRetryButton.hide()
        listNetworkStateTitle.hide()
        listNetworkStateProgressBar.hide()
    }

    private fun setRetryClickListener() = itemView.listNetworkStateRetryButton
        .setOnClickListener { onRetryClickedListener?.invoke() }

    private fun showProgressBar() = itemView.listNetworkStateProgressBar.show()

    private fun showStateTitle() = itemView.listNetworkStateTitle.show()

    private fun showRetryButton() = itemView.listNetworkStateRetryButton.show()
}