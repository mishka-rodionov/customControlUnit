package com.rodionov.customview.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import java.util.*

@Parcelize
class ControlUnit(
    val number: Int = 0,
    val name: String = "",
    val date: Date = Date(),
    val isPassed: Boolean = false
) : Parcelable