package com.ryl.countrylist.domain.model

/**
 * Created by Andrzej Ryl
 */
abstract class BasePagedResults<T>(
    val data: List<T>,
    val hasNextPage: Boolean,
    val hasPreviousPage: Boolean
)