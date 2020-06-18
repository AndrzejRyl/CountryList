package com.ryl.countrylist.data.datasource.country

import androidx.paging.DataSource
import com.ryl.countrylist.data.datasource.base.BaseDataSourceFactory
import com.ryl.countrylist.domain.model.Country
import com.ryl.countrylist.domain.repository.CountryRepository

class CountryListDataSourceFactory(
    private val countryRepository: CountryRepository
) : BaseDataSourceFactory<Country>() {

    override fun create(): DataSource<Int, Country> = CountryListDataSource(
        countryRepository
    ).apply {
        source.postValue(this)
    }
}