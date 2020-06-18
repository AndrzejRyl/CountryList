package com.ryl.countrylist.data.network.model

import com.ryl.countrylist.domain.model.Country
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryDto(
    @Json(name = "name") val name: String?,
    @Json(name = "currencies") val currencies: List<CurrencyDto>,
    @Json(name = "callingCodes") val phoneNumberCodes: List<String>,
    @Json(name = "topLevelDomain") val domainNames: List<String>
)

fun CountryDto.toCountry() = Country(
    name = this.name ?: "",
    currency = this.currencies.first().name ?: "",
    phoneNumberCode = this.phoneNumberCodes.first(),
    internetDomainName = this.domainNames.first()
)

@JsonClass(generateAdapter = true)
data class CurrencyDto(
    @Json(name = "name") val name: String?
)