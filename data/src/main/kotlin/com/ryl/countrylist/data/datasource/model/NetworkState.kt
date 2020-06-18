package com.ryl.countrylist.data.datasource.model

/**
 * Created by Andrzej Ryl
 */
enum class NetworkState {
    RUNNING,
    SUCCESS,
    FAILED
}

fun NetworkState?.isSuccess(): Boolean {
    return this == NetworkState.SUCCESS
}