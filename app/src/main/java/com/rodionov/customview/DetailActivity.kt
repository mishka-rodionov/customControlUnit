package com.rodionov.customview

import android.content.res.TypedArray
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rodionov.customview.MainActivity.Companion.KEY_UNITS
import com.rodionov.customview.entity.ControlUnit
import com.rodionov.customview.extension.getScreenWidth
import com.rodionov.customview.view.ControlUnitView
import com.rodionov.customview.view.RacePointView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val units =
            intent.extras?.getParcelableArrayList<ControlUnit>(KEY_UNITS) as ArrayList<ControlUnit>

//        val circle = RacePointView(this, units)
//        circle.setOnClickListener {
//            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
//        }
//        viewContainer.addView(circle)
//        viewContainer.invalidate()

        units.forEachIndexed { index, controlUnit ->
            val controlUnitView = ControlUnitView(this, units, index, this.getScreenWidth())
            controlUnitView.setOnClickListener {
                Toast.makeText(this, "Click ${controlUnitView.getIndex()}", Toast.LENGTH_SHORT).show()
            }
            viewContainer.addView(controlUnitView)
            viewContainer.invalidate()
        }


        Log.d("LOG_TAG", "DetailActivity units = ${units}")
    }

}