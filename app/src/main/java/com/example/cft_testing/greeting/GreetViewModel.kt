package com.example.cft_testing.greeting

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cft_testing.R

class GreetViewModel(val app: Application) : AndroidViewModel(app) {
    private fun getCurrentUser(): String {
        return "sup"
    }

    fun greetCurrentUser(): String {
        return "${app.getString(R.string.hello)} ${getCurrentUser()}"
    }


}