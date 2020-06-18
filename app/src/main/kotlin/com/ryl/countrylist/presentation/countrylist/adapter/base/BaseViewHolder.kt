package com.ryl.countrylist.presentation.countrylist.adapter.base

/**
 * Created by Andrzej Ryl
 */
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<in T>(
    @LayoutRes layoutRes: Int,
    parent: ViewGroup,
    layoutInflater: LayoutInflater
) : RecyclerView.ViewHolder(layoutInflater.inflate(layoutRes, parent, false)) {

    abstract fun bind(item: T)
}

abstract class BasePagedViewHolder<in T>(
    @LayoutRes layoutRes: Int,
    parent: ViewGroup,
    layoutInflater: LayoutInflater
) : RecyclerView.ViewHolder(layoutInflater.inflate(layoutRes, parent, false)) {

    abstract fun bind(item: T?)
}