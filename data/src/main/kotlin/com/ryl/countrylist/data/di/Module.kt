package com.ryl.countrylist.data.di

import androidx.room.Room
import com.readystatesoftware.chuck.ChuckInterceptor
import com.ryl.countrylist.data.datasource.country.CountryListDataSourceFactory
import com.ryl.countrylist.data.local.Database
import com.ryl.countrylist.data.network.CountriesAPI
import com.ryl.countrylist.data.repository.CountryRepositoryImpl
import com.ryl.countrylist.data.repository.LastListUpdateRepositoryImpl
import com.ryl.countrylist.domain.repository.CountryRepository
import com.ryl.countrylist.domain.repository.LastListUpdateRepository
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

const val COUNTRIES_API_URL = "https://restcountries.eu/rest/v2/"

val dataModule = module {
    single(createdAtStart = true) {
        Room.databaseBuilder(
            get(),
            Database::class.java,
            Database.NAME
        ).build()
    }
    factory {
        get<Database>().countryDao()
    }
    single {
        Moshi.Builder().build()
    }
    factory {
        Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(get()))
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(ChuckInterceptor(androidContext()))
            .build()
    }
    single {
        get<Retrofit.Builder>()
            .client(get())
            .baseUrl(COUNTRIES_API_URL)
            .build()
            .create(CountriesAPI::class.java)
    }
    factory {
        CountryListDataSourceFactory(
            countryRepository = get()
        )
    }
    factory<CountryRepository> {
        CountryRepositoryImpl(
            countriesAPI = get(),
            countryDao = get(),
            lastListUpdateRepository = get()
        )
    }
    factory<LastListUpdateRepository> {
        LastListUpdateRepositoryImpl(
            context = androidContext()
        )
    }
}