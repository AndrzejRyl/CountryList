package com.ryl.countrylist.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.ryl.countrylist.domain.model.Country

@Entity(tableName = "countries", primaryKeys = ["name"])
data class CountryEntity(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "currency") val currency: String,
    @ColumnInfo(name = "phoneNumberCode") val phoneNumberCode: String,
    @ColumnInfo(name = "internetDomain") val internetDomainName: String
)

fun Country.toCountryEntity() = CountryEntity(
    name = this.name,
    currency = this.currency,
    phoneNumberCode = this.phoneNumberCode,
    internetDomainName = this.internetDomainName
)

fun CountryEntity.toCountry() = Country(
    name = this.name,
    currency = this.currency,
    phoneNumberCode = this.phoneNumberCode,
    internetDomainName = this.internetDomainName
)