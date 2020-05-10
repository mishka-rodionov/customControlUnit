package com.rodionov.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.participant_view.view.*

class ParticipantView : RelativeLayout {

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    }

    init {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        layoutInflater.inflate(R.layout.participant_view, this)
        this.tvPlayerName.text = "Player 123"
        this.cvRacePoint.setCount(3)
        this.cvRacePoint.setRadius(20F)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        this.setCount(5)
        this.setRadius(20F)
    }

    fun setName(name: String) {
        this.tvPlayerName.text = name
    }

    fun setCount(count : Int) {
        this.cvRacePoint.setCount(count)
    }

    fun setRadius(radius: Float) {
        this.cvRacePoint.setRadius(radius)
    }

}