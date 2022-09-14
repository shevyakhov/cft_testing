package com.example.cft_testing.registration

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import com.example.cft_testing.R
import java.util.*

class RegistrationViewModel(private val app: Application) : AndroidViewModel(app) {

    fun registerUser(user: User) {
        val sharedPrefs: SharedPreferences =
            app.getSharedPreferences(app.getString(R.string.sharedPrefs), Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPrefs.edit()
        editor.putString("key", "value")
        editor.apply()
    }

    fun isSurnameCorrect(surname: String) = surname.trim().length >= 2

    fun isNameCorrect(name: String) = name.trim().isNotEmpty()

    fun isDateCorrect(date: MDate): Boolean {
        val c = Calendar.getInstance()
        return date.year <= c.get(Calendar.YEAR) && date.month <= c.get(Calendar.MONTH) && date.day <= c.get(
            Calendar.DAY_OF_MONTH
        )
    }

    fun isPasswordCorrect(password: String): Boolean {
        val (letterOrDigit, others) = password.partition { it.isLetterOrDigit() }
        if (others.isNotEmpty()) {
            return false
        }
        val digits = letterOrDigit.filter { it.isDigit() }
        val (uppercase, lowercase) = letterOrDigit.partition { it.isUpperCase() }
        return uppercase.isNotEmpty() && lowercase.isNotEmpty() && digits.isNotEmpty() && password.length > 5

    }


}