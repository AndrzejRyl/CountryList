package com.ryl.countrylist.data.di

import com.ryl.countrylist.data.datasource.country.CountryListDataSourceFactory
import org.koin.dsl.module

val dataModule = module {

    factory {
        CountryListDataSourceFactory(
            countryRepository = get()
        )
    }
}