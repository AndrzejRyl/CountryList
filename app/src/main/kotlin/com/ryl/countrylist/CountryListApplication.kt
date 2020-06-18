package com.ryl.countrylist

import android.app.Application
import com.ryl.countrylist.data.di.dataModule
import com.ryl.countrylist.di.presentationModule
import com.ryl.countrylist.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CountryListApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupDI()
    }

    private fun setupDI() {
        startKoin {
            androidLogger()
            androidContext(this@CountryListApplication)
            modules(modules = presentationModule + domainModule + dataModule)
        }
    }
}