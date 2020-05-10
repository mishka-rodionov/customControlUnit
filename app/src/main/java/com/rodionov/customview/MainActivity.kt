package com.rodionov.customview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.rodionov.customview.delegates.racePointDelegate
import com.rodionov.customview.entity.ControlUnit
import com.rodionov.customview.extension.dpToPx
import com.rodionov.customview.extension.getScreenWidth
import com.rodionov.customview.extension.pxToDp
import com.rodionov.customview.extension.setData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val racePointDelegateAdapter by lazy {
        ListDelegationAdapter(racePointDelegate())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("LOG_TAG", "screen width = ${this.getScreenWidth()}")
        Log.d("LOG_TAG", "dp to px = ${1.dpToPx}")
        Log.d("LOG_TAG", "px to dp = ${this.getScreenWidth().pxToDp}")

        rvParticipants.adapter = racePointDelegateAdapter
        racePointDelegateAdapter.setData(listOf(ControlUnit(5), ControlUnit(3)))

//        val circle = RacePointView(this, 30, 30,9, 30F)
//        container.addView(circle)
//        container.invalidate()

    }
}
