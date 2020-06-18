package com.ryl.countrylist.utils

import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible


fun View.hide() {
    isGone = true
}

fun View.show() {
    isVisible = true
}