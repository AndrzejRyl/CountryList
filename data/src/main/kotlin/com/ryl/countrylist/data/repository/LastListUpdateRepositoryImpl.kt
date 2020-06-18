package com.ryl.countrylist.data.repository

import android.content.Context
import com.ryl.countrylist.domain.repository.LastListUpdateRepository

class LastListUpdateRepositoryImpl(private val context: Context) : LastListUpdateRepository {

    private val sharedPrefs = context.getSharedPreferences(LAST_UPDATE_SP, Context.MODE_PRIVATE)

    override fun getLastUpdateTimestamp() = sharedPrefs.getLong(LAST_UPDATE_KEY, 0L)

    override fun updateLastUpdateTimestamp() {
        sharedPrefs
            .edit()
            .putLong(LAST_UPDATE_KEY, System.currentTimeMillis())
            .apply()
    }

    companion object {
        private const val LAST_UPDATE_SP = "LAST_UPDATE"
        private const val LAST_UPDATE_KEY = "LAST_UPDATE_KEY"
    }
}