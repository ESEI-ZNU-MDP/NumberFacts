package com.example.numberfacts.controllers
import com.example.numberfacts.models.NumberFactModel

class MainController(
    val model: NumberFactModel
) {
    fun getFactButtonPressed(number: Int) {
        model.getFact(number = number)
    }
}