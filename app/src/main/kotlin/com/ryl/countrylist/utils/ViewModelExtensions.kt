package com.ryl.countrylist.utils

import androidx.lifecycle.ViewModel
import androidx.paging.PagedList


fun ViewModel.pagedListConfig(pageSize: Int): PagedList.Config =
    PagedList.Config.Builder()
        .setInitialLoadSizeHint(pageSize)
        .setEnablePlaceholders(false)
        .setPageSize(pageSize)
        .build()