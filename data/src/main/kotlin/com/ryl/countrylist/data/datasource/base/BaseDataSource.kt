package com.ryl.countrylist.data.datasource.base

/**
 * Created by Andrzej Ryl
 */
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.ryl.countrylist.core.dispatcher.DefaultDispatcherProvider
import com.ryl.countrylist.core.dispatcher.DispatcherProvider
import com.ryl.countrylist.data.datasource.model.NetworkState
import com.ryl.countrylist.domain.model.BasePagedResults
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseDataSource<BaseDataSourceModel>(
    private val dispatcherProvider: DispatcherProvider = DefaultDispatcherProvider()
) : PageKeyedDataSource<Int, BaseDataSourceModel>(), CoroutineScope {

    abstract val tag: String
    abstract suspend fun loadData(page: Int, limit: Int): BasePagedResults<BaseDataSourceModel>

    private val networkState = MutableLiveData<NetworkState>()
    private var retryAction: (() -> Any)? = null

    override val coroutineContext: CoroutineContext
        get() = dispatcherProvider.io

    private val errorHandler = CoroutineExceptionHandler { _, e ->
        Log.e(tag, "Error while fetching data: $e")
        networkState.postValue(NetworkState.FAILED)
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, BaseDataSourceModel>
    ) {
        retryAction = { loadInitial(params, callback) }

        loadDataHandlingNetworkState(FIRST_PAGE_INDEX, params.requestedLoadSize) {
            callback.onResult(
                it.data,
                null,
                if (it.hasNextPage) SECOND_PAGE_INDEX else null
            )
        }
    }

    private fun loadDataHandlingNetworkState(
        page: Int,
        limit: Int,
        callback: (BasePagedResults<BaseDataSourceModel>) -> Unit
    ) {
        networkState.postValue(NetworkState.RUNNING)
        launch(coroutineContext + errorHandler) {
            delay(TYPING_BACKOFF)
            val data = loadData(page, limit)
            retryAction = null
            networkState.postValue(NetworkState.SUCCESS)
            callback(data)
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, BaseDataSourceModel>
    ) {
        retryAction = { loadAfter(params, callback) }

        loadDataHandlingNetworkState(params.key, params.requestedLoadSize) {
            callback.onResult(
                it.data,
                if (it.hasNextPage) params.key + 1 else null
            )
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, BaseDataSourceModel>
    ) {
        retryAction = { loadBefore(params, callback) }

        loadDataHandlingNetworkState(params.key, params.requestedLoadSize) {
            callback.onResult(
                it.data,
                if (it.hasPreviousPage) params.key - 1 else null
            )
        }
    }

    override fun invalidate() {
        super.invalidate()
        // Cancel possible running job to only keep last result searched by user
        coroutineContext.cancelChildren()
    }

    fun getNetworkState(): LiveData<NetworkState> = networkState

    fun retry() {
        val previousAction = retryAction
        retryAction = null
        previousAction?.invoke()
    }

    companion object {
        private const val TYPING_BACKOFF = 500L
        private const val FIRST_PAGE_INDEX = 1
        private const val SECOND_PAGE_INDEX = 2
    }
}