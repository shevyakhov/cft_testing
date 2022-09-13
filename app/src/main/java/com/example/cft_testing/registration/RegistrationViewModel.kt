package com.example.cft_testing.registration

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import com.example.cft_testing.R

class RegistrationViewModel(private val app: Application) : AndroidViewModel(app) {

    fun registerUser(user: User) {
        val sharedPrefs: SharedPreferences =
            app.getSharedPreferences(app.getString(R.string.sharedPrefs), Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPrefs.edit()
        editor.putString("key", "value")
        editor.apply()
    }
}