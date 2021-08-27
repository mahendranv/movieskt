package com.ex2.ktmovies.common.extensions

import android.view.View

fun View.showIf(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.GONE
}