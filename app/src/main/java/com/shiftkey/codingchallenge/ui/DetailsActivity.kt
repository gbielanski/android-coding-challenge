package com.shiftkey.codingchallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.shiftkey.codingchallenge.domain.ShiftItem

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shiftItem = intent.extras?.get(SHIFT_DETAILS) as ShiftItem
        setContent {
            DetailedScreen(screenState = shiftItem, onButtonClicked = {
                finish()
            })
        }
    }

    companion object {
        const val SHIFT_DETAILS = "SHIFT_DETAILS"
    }
}