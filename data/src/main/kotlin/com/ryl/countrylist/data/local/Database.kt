package com.ryl.countrylist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ryl.countrylist.data.local.Database.Companion.VERSION
import com.ryl.countrylist.data.local.dao.CountryDao
import com.ryl.countrylist.data.local.model.CountryEntity


@Database(
    entities = [
        CountryEntity::class
    ],
    version = VERSION
)
abstract class Database : RoomDatabase() {

    abstract fun countryDao(): CountryDao

    companion object {

        const val NAME = "countries.db"
        const val VERSION = 1
    }
}