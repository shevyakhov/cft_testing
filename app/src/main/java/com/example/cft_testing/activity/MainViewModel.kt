package com.example.cft_testing.activity

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import com.example.cft_testing.R

class MainViewModel(private val app: Application) : AndroidViewModel(app) {
    fun isRegistered(): Boolean {
        val sharedPrefs: SharedPreferences =
            app.getSharedPreferences(app.getString(R.string.sharedPrefs), Context.MODE_PRIVATE)
        return sharedPrefs.getBoolean(app.getString(R.string.sharedPrefsIsRegistered), false)
    }

}