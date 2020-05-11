package com.rodionov.customview.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.rodionov.customview.R
import com.rodionov.customview.entity.ControlUnit


class RacePointView : View {

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(
        context: Context?,
        units : List<ControlUnit>
    ) : this(context) {
        this.controlUnits = units
    }

    private var count: Int = 0
    private var radius: Float = 20F
    private val paint = Paint()
    private val pathPaint = Paint()
    private var controlUnits: List<ControlUnit>

    init {
        paint.color = resources.getColor(R.color.grayColor)
        paint.strokeWidth = 20F

        pathPaint.style = Paint.Style.STROKE
        pathPaint.strokeWidth = 10F
        pathPaint.color = resources.getColor(R.color.grayColor)
        controlUnits = listOf()
    }

    fun setControlUnits(units: List<ControlUnit>) {
        this.controlUnits = units
    }

    fun setCount(count: Int) {
        this.count = count
    }

    fun setRadius(radius: Float) {
        this.radius = radius
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        var height = 0

        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)

        when (heightMode) {
            MeasureSpec.AT_MOST -> height = heightSize
            MeasureSpec.EXACTLY -> height = 50
            MeasureSpec.UNSPECIFIED -> height = 50
        }

        setMeasuredDimension(widthSize, height)
    }

    override fun onDraw(canvas: Canvas) {
        drawRacePoint(
            canvas,
            DrawViewHelper.getCoordinates(
                units = controlUnits,
                width = width,
                paddingLeft = paddingLeft,
                paddingRight = paddingRight
            ),
            DrawViewHelper.getTraceStatus(units = controlUnits)
        )
    }

    private fun drawRacePoint(canvas: Canvas, coordinates: List<Float>, status: List<TraceStatus>) {
        val yCoord = height.toFloat() / 2
        coordinates.forEachIndexed { index, fl ->
            if (index != coordinates.size - 1)
                canvas.drawLine(fl, yCoord, coordinates[index + 1], yCoord, pathPaint.apply {
                    color = getPaint(status = status[index + 1])
                })
        }
        coordinates.forEachIndexed {index, fl ->
            canvas.drawCircle(fl, yCoord, radius, paint.apply {
                color = getPaint(status = status[index])
            })
        }
    }

    private fun getPaint(status: TraceStatus) = when (status) {
        TraceStatus.PASSED -> resources.getColor(R.color.greenColor)
        TraceStatus.NOT_PASSED -> resources.getColor(R.color.grayColor)
        TraceStatus.FAILED -> resources.getColor(R.color.redColor)
    }
}