package com.ryl.countrylist.data.repository

import com.ryl.countrylist.data.network.CountriesAPI
import com.ryl.countrylist.data.network.model.toCountry
import com.ryl.countrylist.domain.repository.CountryRepository
import com.ryl.countrylist.domain.repository.CountryResults

class CountryRepositoryImpl(
    private val countriesAPI: CountriesAPI
) : CountryRepository {

    override suspend fun getCountries(page: Int, limit: Int): CountryResults =
        countriesAPI.getCountries().run {
            CountryResults(
                countries = this.map { it.toCountry() },
                hasPreviousCountryPage = false,
                hasNextCountryPage = false
            )
        }
}