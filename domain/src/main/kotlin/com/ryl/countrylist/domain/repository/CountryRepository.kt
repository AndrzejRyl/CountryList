package com.ryl.countrylist.domain.repository

import com.ryl.countrylist.domain.model.BasePagedResults
import com.ryl.countrylist.domain.model.Country

interface CountryRepository {

    fun getCountries(page: Int, limit: Int): CountryResults
}

data class CountryResults(
    val countries: List<Country>,
    val hasNextCountryPage: Boolean,
    val hasPreviousCountryPage: Boolean
) : BasePagedResults<Country>(countries, hasNextCountryPage, hasPreviousCountryPage)
