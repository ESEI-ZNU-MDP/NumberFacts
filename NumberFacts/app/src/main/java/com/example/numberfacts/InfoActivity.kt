package com.example.numberfacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class InfoActivity : AppCompatActivity() {
    private var clearButton: Button? = null
    private var numberTextView: TextView? = null
    private var descriptionTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        clearButton = findViewById<Button>(R.id.btnBottom)
        numberTextView = findViewById<TextView>(R.id.tvTopText)
        descriptionTextView = findViewById<TextView>(R.id.tvMiddleText)

        val number = intent.getIntExtra("number", 0).toString()
        numberTextView?.setText(number)

        val fact = intent.getStringExtra("fact")
        descriptionTextView?.setText(fact)

        setListeners()
    }

    private fun setListeners() {
        clearButton?.setOnClickListener {
            clearAndBackToMainScreen()
        }
    }
    private fun clearAndBackToMainScreen() {
        val intent = Intent()
        intent.putExtra("result", 0)
        setResult(0, intent)
        finish()
    }
}