package com.ryl.countrylist.data.network

import com.ryl.countrylist.data.network.model.CountryDto
import retrofit2.http.GET

interface CountriesAPI {

    @GET("all")
    suspend fun getCountries(): List<CountryDto>
}