package com.ryl.countrylist.presentation.countrylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ryl.countrylist.R
import com.ryl.countrylist.presentation.countrylist.adapter.base.BaseNetworkStateViewHolder
import com.ryl.countrylist.presentation.countrylist.adapter.base.OnRetryClickedListener

class CountryListNetworkStateViewHolder(
    parent: ViewGroup,
    layoutInflater: LayoutInflater,
    onRetryClickedListener: OnRetryClickedListener?
) : BaseNetworkStateViewHolder(parent, layoutInflater, onRetryClickedListener) {

    override val failureInfoResId: Int = R.string.fetch_fail
}