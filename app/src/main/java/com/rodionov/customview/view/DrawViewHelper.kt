package com.rodionov.customview.view

import android.view.ViewGroup
import com.rodionov.customview.entity.ControlUnit

class DrawViewHelper {

    companion object {

        private var radius = 20F

        fun getTraceStatus(units: List<ControlUnit>) : List<TraceStatus> {
            val statusList = mutableListOf<TraceStatus>()
            for (i in units.size - 1 downTo 0) {
                if (i == units.size - 1) {
                    if (units[i].isPassed)
                        statusList.add(TraceStatus.PASSED)
                    else
                        statusList.add(TraceStatus.NOT_PASSED)
                }
                else {
                    if (units[i + 1].isPassed == units[i].isPassed) {
                        statusList.add(statusList[statusList.size - 1])
                    } else {
                        if (units[i].isPassed)
                            statusList.add(TraceStatus.PASSED)
                        else
                            statusList.add(TraceStatus.FAILED)
                    }
                }
            }
            statusList.reverse()
            return statusList
        }

        private fun getXPos(value: Float, width: Int, paddingLeft: Int, paddingRight : Int, count : Int): Float {
            var localValue = value
            val width = width - paddingLeft.toFloat() - paddingRight.toFloat() - 2 * radius
            val maxValue: Int = count - 1

            // масштабирования под размер view
            localValue = localValue / maxValue * width

            // смещение чтобы учесть padding
            localValue += paddingLeft.toFloat() + radius
            return localValue
        }

        fun getCoordinates(units : List<ControlUnit>, width: Int, paddingLeft: Int, paddingRight : Int) : List<Float> {
            val coordinates = mutableListOf<Float>()
            coordinates.add(getXPos(0F, width, paddingLeft, paddingRight, units.size))
            for (i in 1 until units.size) {
                coordinates.add(getXPos(i.toFloat(), width, paddingLeft, paddingRight, units.size))
            }
            return coordinates
        }

        fun addViewToContainer(container : ViewGroup) {

        }

    }

}