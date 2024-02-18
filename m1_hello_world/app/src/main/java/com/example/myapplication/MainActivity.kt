package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var seatsTextView: TextView
    private lateinit var decrementButton: Button
    private lateinit var incrementButton: Button
    private lateinit var resetButton: Button
    private var availableSeats: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seatsTextView = findViewById(R.id.seatsTextView)
        decrementButton = findViewById(R.id.decrementButton)
        incrementButton = findViewById(R.id.incrementButton)
        resetButton = findViewById(R.id.resetButton)

        updateUI()

        decrementButton.setOnClickListener {
            if (availableSeats > 0) {
                availableSeats--
                updateUI()
            }
        }

        incrementButton.setOnClickListener {
            if (availableSeats < 50) {
                availableSeats ++
                if (availableSeats == 50) {
                    resetButton.visibility = View.VISIBLE
                }
                updateUI()
            }
        }

        resetButton.setOnClickListener {
            availableSeats = 0
            resetButton.visibility = View.INVISIBLE
            updateUI()
        }
    }

    private fun updateUI() {
        seatsTextView.text = availableSeats.toString()
        when {
            availableSeats == 0 -> {
                seatsTextView.setTextColor(Color.GREEN)
                decrementButton.isEnabled = false
            }
            availableSeats in 1..49 -> {
                seatsTextView.setTextColor(Color.BLUE)
                decrementButton.isEnabled = true
            }
            else -> {
                seatsTextView.setTextColor(Color.RED)
                decrementButton.isEnabled = true
            }
        }
    }
}