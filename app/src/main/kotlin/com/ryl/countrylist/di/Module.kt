package com.ryl.countrylist.di

import com.ryl.countrylist.presentation.countrylist.viewmodel.CountryListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        CountryListViewModel(
            countryListDataSourceFactory = get()
        )
    }
}