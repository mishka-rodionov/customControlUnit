package com.rodionov.customview.extension

import android.content.res.Resources
import com.hannesdorfmann.adapterdelegates4.AbsDelegationAdapter

val Int.dpToPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

val Float.dpToPx: Float
    get() = (this * Resources.getSystem().displayMetrics.density)

val Int.pxToDp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

fun <T> AbsDelegationAdapter<T>.setData(data: T) {
    items = data
    notifyDataSetChanged()
}