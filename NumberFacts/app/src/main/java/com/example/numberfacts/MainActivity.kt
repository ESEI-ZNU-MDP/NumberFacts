package com.example.numberfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.numberfacts.controllers.MainController
import com.example.numberfacts.models.NumberFactModel
import com.example.numberfacts.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    private val model = NumberFactModel(this)
    private val controller = MainController(model)
    private val viewModel: MainViewModel by viewModels()

    private var getFactButton: Button? = null
    private var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getFactButton = findViewById<Button>(R.id.btnGetFact)
        editText = findViewById<EditText>(R.id.etNumber)
        editText?.setText(viewModel.getInputText())
        setContentView(R.layout.activity_main)
        setListeners()
    }

    override fun onDestroy() {
        viewModel.saveText(editText?.text.toString())
        super.onDestroy()
    }

    fun openInfoScreen() {
        //TODO:
    }

    private fun setListeners() {
        getFactButton?.setOnClickListener {
            controller.getFactButtonPressed(editText?.text.toString().toInt())
        }
    }
}