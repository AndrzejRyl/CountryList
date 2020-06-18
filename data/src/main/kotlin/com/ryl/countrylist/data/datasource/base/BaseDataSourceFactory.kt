package com.ryl.countrylist.data.datasource.base

/**
 * Created by Andrzej Ryl
 */
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

abstract class BaseDataSourceFactory<BaseDataSourceModel>(
) : DataSource.Factory<Int, BaseDataSourceModel>() {

    val source = MutableLiveData<BaseDataSource<BaseDataSourceModel>>()

    abstract override fun create(): DataSource<Int, BaseDataSourceModel>

    fun getSource() = source.value
}