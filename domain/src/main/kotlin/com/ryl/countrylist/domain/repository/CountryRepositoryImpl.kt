package com.ryl.countrylist.domain.repository

import com.ryl.countrylist.domain.model.Country

class CountryRepositoryImpl : CountryRepository {

    override fun getCountries(page: Int, limit: Int): CountryResults = CountryResults(
        listOf(
            Country("Poland", "zł", "111 222 333", "pl")
        ),
        false,
        false
    )
}