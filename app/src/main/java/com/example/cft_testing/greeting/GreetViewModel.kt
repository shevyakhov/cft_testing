package com.example.cft_testing.greeting

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import com.example.cft_testing.R

class GreetViewModel(val app: Application) : AndroidViewModel(app) {
    private fun getCurrentUser(): String {
        val sharedPrefs: SharedPreferences =
            app.getSharedPreferences(app.getString(R.string.sharedPrefs), Context.MODE_PRIVATE)
        val surname = sharedPrefs.getString(
            app.getString(R.string.sharedPrefsSurname),
            app.getString(R.string.empty)
        )
        val name = sharedPrefs.getString(
            app.getString(R.string.sharedPrefsName),
            app.getString(R.string.empty)
        )
        return "$surname $name"
    }

    fun greetCurrentUser(): String {
        return "${app.getString(R.string.hello)} ${getCurrentUser()}!!!"
    }


}