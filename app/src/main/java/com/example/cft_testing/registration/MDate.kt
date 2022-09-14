package com.example.cft_testing.registration

data class MDate(val day: Int, val month: Int, val year: Int) {
    override fun toString(): String {
        return "$day-$month-$year"
    }
}