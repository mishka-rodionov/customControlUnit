package com.rodionov.customview.extension

import android.app.Activity
import android.graphics.Point

fun Activity.getScreenWidth() : Int {
    val display = this.windowManager.defaultDisplay
    val point = Point()
    display.getSize(point)
    return point.x
}