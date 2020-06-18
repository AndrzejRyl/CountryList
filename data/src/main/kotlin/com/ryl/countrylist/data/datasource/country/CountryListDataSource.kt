package com.ryl.countrylist.data.datasource.country

import com.ryl.countrylist.data.datasource.base.BaseDataSource
import com.ryl.countrylist.domain.model.Country
import com.ryl.countrylist.domain.repository.CountryRepository
import kotlinx.coroutines.CoroutineScope

class CountryListDataSource(
    private val countryRepository: CountryRepository
) : BaseDataSource<Country>(), CoroutineScope {

    override val tag: String = "CountryDataSource"

    override suspend fun loadData(page: Int, limit: Int) =
        countryRepository.getCountries(page, limit)
}