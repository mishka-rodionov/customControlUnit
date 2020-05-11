package com.rodionov.customview

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.rodionov.customview.delegates.racePointDelegate
import com.rodionov.customview.entity.ControlUnit
import com.rodionov.customview.extension.dpToPx
import com.rodionov.customview.extension.getScreenWidth
import com.rodionov.customview.extension.pxToDp
import com.rodionov.customview.extension.setData
import com.rodionov.customview.view.DrawViewHelper
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val racePointDelegateAdapter by lazy {
        ListDelegationAdapter(racePointDelegate(::showCustomView))
    }

    private fun showCustomView(units: List<ControlUnit>) {
        val intent = Intent(this, DetailActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelableArrayList(KEY_UNITS, ArrayList(units))
//        intent.putExtra(KEY_UNITS, "hello world")
        Log.d("LOG_TAG", "MainActivity units = ${units}")
        intent.putExtras(bundle)
        startActivity(
            intent
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Log.d("LOG_TAG", "screen width = ${this.getScreenWidth()}")
//        Log.d("LOG_TAG", "dp to px = ${1.dpToPx}")
//        Log.d("LOG_TAG", "px to dp = ${this.getScreenWidth().pxToDp}")

        rvParticipants.adapter = racePointDelegateAdapter
        racePointDelegateAdapter.setData(
            listOf(
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = true)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = true)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                ),
                listOf(
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = true),
                    ControlUnit(isPassed = false),
                    ControlUnit(isPassed = false)
                )
            )
        )

        DrawViewHelper.getTraceStatus(
            listOf(
                ControlUnit(isPassed = true),
                ControlUnit(isPassed = false),
                ControlUnit(isPassed = true),
                ControlUnit(isPassed = false),
                ControlUnit(isPassed = false)
            )
        )/*.forEach {
            Log.d("LOG_TAG", "status = $it")
        }*/
//        val circle = RacePointView(this, 30, 30,9, 30F)
//        container.addView(circle)
//        container.invalidate()

    }

    companion object {
        const val KEY_UNITS = "KeyUnits"
    }
}
