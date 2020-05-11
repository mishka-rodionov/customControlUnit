package com.rodionov.customview.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.rodionov.customview.R
import com.rodionov.customview.entity.ControlUnit

class ControlUnitView : View {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, units: List<ControlUnit>, index: Int, width : Int) : super(context) {
        controlUnits = units
        this.index = index
        mWidth = width
    }

    private val paint = Paint()
    private var radius: Float = 20F
    private var controlUnits: List<ControlUnit>
    private var index: Int
    private var mWidth : Int

    init {
        paint.color = resources.getColor(R.color.grayColor)
        paint.strokeWidth = 20F
        controlUnits = listOf()
        index = 0
        mWidth = 0
    }

    fun getIndex() = index

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        var height = 0
        var width = 0

        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)

        when (heightMode) {
            MeasureSpec.AT_MOST -> {
                height = heightSize
            }
            MeasureSpec.EXACTLY -> {
                height = 50
            }
            MeasureSpec.UNSPECIFIED -> {
                height = 50
            }
        }

//        when(widthMode) {
//            MeasureSpec.AT_MOST -> {
//                width = widthMeasureSpec
//            }
//            MeasureSpec.EXACTLY -> {
//                width = (2 * radius).toInt()
//            }
//            MeasureSpec.UNSPECIFIED -> {
//                width = (2 * radius).toInt()
//            }
//        }
//        Log.d("LOG_TAG", "widthMeasureSpec = $widthMeasureSpec")
        setMeasuredDimension(widthMeasureSpec , height)
    }

    override fun onDraw(canvas: Canvas) {
        Log.d("LOG_TAG", "onDraw width = $width")
        drawRacePoint(
            canvas,
            DrawViewHelper.getCoordinates(
                units = controlUnits,
                width = width,
                paddingLeft = paddingLeft,
                paddingRight = paddingRight
            ),
            DrawViewHelper.getTraceStatus(units = controlUnits), index
        )
    }

    private fun drawRacePoint(
        canvas: Canvas,
        coordinates: List<Float>,
        status: List<TraceStatus>,
        index: Int
    ) {
        val yCoord = height.toFloat() / 2
        Log.d("LOG_TAG", "coordinates $index = ${coordinates[index]}")
        coordinates.forEach {
            Log.d("LOG_TAG", "coordinates $it")
        }
        canvas.drawCircle(coordinates[index], yCoord, radius, paint.apply {
            color = getPaint(status = status[index])
        })
    }

    private fun getPaint(status: TraceStatus) = when (status) {
        TraceStatus.PASSED -> resources.getColor(R.color.greenColor)
        TraceStatus.NOT_PASSED -> resources.getColor(R.color.grayColor)
        TraceStatus.FAILED -> resources.getColor(R.color.redColor)
    }

}