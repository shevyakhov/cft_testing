package com.example.cft_testing.registration

import java.util.*

data class User(
    val surname: String,
    val name: String,
    var dateOfBirth: Date,
    var password: String
)
