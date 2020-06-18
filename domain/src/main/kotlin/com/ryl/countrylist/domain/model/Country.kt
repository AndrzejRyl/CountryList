package com.ryl.countrylist.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    val name: String,
    val currency: String,
    val phoneNumberCode: String,
    val internetDomainName: String
) : Parcelable