package com.ryl.countrylist.domain.repository

interface LastListUpdateRepository {
    fun getLastUpdateTimestamp(): Long
    fun updateLastUpdateTimestamp()
}