package com.ryl.countrylist.domain.di

import com.ryl.countrylist.domain.repository.CountryRepository
import com.ryl.countrylist.domain.repository.CountryRepositoryImpl
import org.koin.dsl.module

val domainModule = module {

    factory<CountryRepository> { CountryRepositoryImpl() }

}