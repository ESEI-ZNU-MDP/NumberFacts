package com.example.numberfacts.models
import com.example.numberfacts.MainActivity


data class NumberFactModel(
    private val activity: MainActivity
) {

    fun getFact(number: Int) {
        //TODO: request
        activity.openInfoScreen()
    }
}
