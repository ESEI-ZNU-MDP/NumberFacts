package com.example.numberfacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toolbar
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.numberfacts.controllers.MainController
import com.example.numberfacts.models.NumberFactModel
import com.example.numberfacts.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    private val model = NumberFactModel(this)
    private val controller = MainController(model)
    private val viewModel: MainViewModel by viewModels()
    private val infoActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        val intent = it.data?.getIntExtra("result", 0).toString()
        editText?.setText(intent)
    }

    private var getFactButton: Button? = null
    private var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getFactButton = findViewById<Button>(R.id.btnGetFact)
        editText = findViewById<EditText>(R.id.etNumber)
        editText?.setText(viewModel.getInputText())
        setListeners()
    }

    override fun onDestroy() {
        viewModel.saveText(editText?.text.toString())
        super.onDestroy()
    }

    fun openInfoScreen(number: Int, fact: String) {
        val intent = Intent(this, InfoActivity::class.java)
        intent.putExtra("number", number)
        intent.putExtra("fact", fact)
        infoActivityResult.launch(intent)
    }

    private fun setListeners() {
        getFactButton?.setOnClickListener {
            controller.getFactButtonPressed(editText?.text.toString().toInt())
        }
    }
}