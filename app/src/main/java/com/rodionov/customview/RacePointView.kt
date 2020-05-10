package com.rodionov.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.rodionov.customview.extension.dpToPx


class RacePointView : View/*(context)*/ {

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(
        context: Context?,
        x: Int = 0,
        y: Int = 0,
        count: Int = 0,
        radius: Float = 0F
    ) : this(context) {
        this.x = x
        this.y = y
        this.count = count
        this.radius = radius
    }

    private var x: Int = 0
    private var y: Int = 0
    private var count: Int = 0
    private var radius: Float = 0F
    private val paint = Paint()
    private val pathPaint = Paint()
    private val textPaint: Paint
    private val bounds: Rect

    init {
        paint.strokeWidth = 20F
        textPaint = Paint()
        bounds = Rect()

        pathPaint.style = Paint.Style.STROKE
        pathPaint.strokeWidth = 10F
        pathPaint.color = -0xcc4a1b
    }

    fun getCustomWidth() {
        width - paddingLeft - paddingRight
    }

    fun setCount(count: Int) {
        this.count = count
    }

    fun setRadius(radius: Float) {
        this.radius = radius
    }

    private fun getXPos(value: Float): Float {
        var localValue = value
        val width = width - paddingLeft.toFloat() - paddingRight.toFloat() - 2 * radius
        val maxValue: Int = count - 1

        // масштабирования под размер view
        localValue = localValue / maxValue * width

        // смещение чтобы учесть padding
        localValue += paddingLeft.toFloat() + radius
        return localValue
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        var height = 0

        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)

        when(heightMode) {
            MeasureSpec.AT_MOST -> height = heightSize
            MeasureSpec.EXACTLY -> height = 50
            MeasureSpec.UNSPECIFIED -> height = 50
        }

        setMeasuredDimension(widthSize, height)
    }

    override fun onDraw(canvas: Canvas) {
        paint.color = Color.RED
        drawRacePoint(canvas)
    }

    private fun drawRacePoint(canvas: Canvas) {
        val yCoord = height.toFloat() / 2
        val path = Path()
        val coordinates = mutableListOf<Float>()
        path.moveTo(getXPos(0F), yCoord)
        coordinates.add(getXPos(0F))
        for (i in 1 until count) {
            val xCoord = getXPos(i.toFloat())
            if (i == count - 1) {
                coordinates.add(xCoord)
                path.lineTo(xCoord, yCoord)
            } else {
                coordinates.add(xCoord)
                path.lineTo(xCoord, yCoord)

            }

        }
        canvas.drawPath(path, pathPaint)
        coordinates.forEach {
            canvas.drawCircle(it, yCoord, radius, paint)
        }
    }
}