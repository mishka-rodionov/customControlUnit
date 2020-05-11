package com.rodionov.customview.delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateLayoutContainer
import com.rodionov.customview.R
import com.rodionov.customview.entity.ControlUnit
import kotlinx.android.synthetic.main.item_participant.view.*

fun racePointDelegate(clickListener: (List<ControlUnit>) -> Unit) =
    adapterDelegateLayoutContainer<List<ControlUnit>, Any>(R.layout.item_participant) {

        containerView.setOnClickListener {
            clickListener(item)
        }

        bind {
            containerView.pvParticipant.setName("Player 12345")
//            containerView.pvParticipant.setCount(5)
            containerView.pvParticipant.setRadius(20F)
            containerView.pvParticipant.setControlUnits(item)
//            containerView.tvPlayerName.text = "PLayer 1"
//            containerView.cvRacePoint.setCount(5)
//            containerView.cvRacePoint.setRadius(20F)
        }
    }

