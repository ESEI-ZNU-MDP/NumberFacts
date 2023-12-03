package com.example.numberfacts.viewModels

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var savedInputText: String = ""

    fun saveText(value: String) {
        savedInputText = value
    }

    fun getInputText(): String {
        return savedInputText
    }
}