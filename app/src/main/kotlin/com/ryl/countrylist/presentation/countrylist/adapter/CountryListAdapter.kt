package com.ryl.countrylist.presentation.countrylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ryl.countrylist.domain.model.Country
import com.ryl.countrylist.presentation.countrylist.adapter.base.BasePagedListAdapter
import com.ryl.countrylist.presentation.countrylist.adapter.base.OnRetryClickedListener

class CountryListAdapter(
    private val layoutInflater: LayoutInflater
) : BasePagedListAdapter<Country>(ItemDiffer(Country::name)) {

    override fun getItemViewHolder(
        parent: ViewGroup
    ): RecyclerView.ViewHolder = CountryViewHolder(parent, layoutInflater)

    override fun getNetworkStateItemViewHolder(
        parent: ViewGroup,
        retryClickedListener: OnRetryClickedListener?
    ): RecyclerView.ViewHolder = CountryListNetworkStateViewHolder(
        parent, layoutInflater,
        retryClickedListener
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) = when (holder) {
        is CountryViewHolder -> holder.bind(getItem(position))
        is CountryListNetworkStateViewHolder -> holder.bind(networkState)
        else -> throw IllegalStateException("Incorrect ViewHolder type!")
    }
}