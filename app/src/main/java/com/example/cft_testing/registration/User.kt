package com.example.cft_testing.registration

data class User(
    val surname: String,
    val name: String,
    var dateOfBirth: MDate,
    var password: String
)