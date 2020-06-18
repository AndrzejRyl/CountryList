package com.ryl.countrylist.presentation.countrylist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import com.ryl.countrylist.data.datasource.country.CountryListDataSourceFactory
import com.ryl.countrylist.data.datasource.model.NetworkState
import com.ryl.countrylist.utils.pagedListConfig

class CountryListViewModel(
    private val countryListDataSourceFactory: CountryListDataSourceFactory
) : ViewModel() {

    val countries = LivePagedListBuilder(
        countryListDataSourceFactory,
        pagedListConfig(LAZY_LOADING_PAGE_SIZE)
    ).build()
    val countryListNetworkState: LiveData<NetworkState>? =
        Transformations.switchMap(countryListDataSourceFactory.source) { it.getNetworkState() }

    fun refreshFailedRequest() = countryListDataSourceFactory.getSource()?.retry()

    companion object {
        private const val LAZY_LOADING_PAGE_SIZE = 10
    }
}