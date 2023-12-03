package com.example.numberfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toolbar
import com.example.numberfacts.controllers.MainController
import com.example.numberfacts.models.NumberFactModel

class MainActivity : AppCompatActivity() {

    private val model = NumberFactModel(this)
    private val controller = MainController(model)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    fun openInfoScreen() {
        //TODO:
    }

    private fun setListeners() {
        val getFactButton = findViewById<Button>(R.id.btnGetFact)
        val editText = findViewById<EditText>(R.id.etNumber)

        getFactButton.setOnClickListener {
            controller.getFactButtonPressed(editText.text.toString().toInt())
        }
    }
}