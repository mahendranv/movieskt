package com.ex2.ktmovies.common.extensions

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.showIf(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.GONE
}

fun View.showKeyboard() {
    postDelayed({
        val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }, 200)
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}