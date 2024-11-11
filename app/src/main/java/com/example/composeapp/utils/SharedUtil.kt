package com.example.composeapp.utils

import android.content.Context
import android.content.SharedPreferences

class SharedUtil(context: Context) {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("shared_util", Context.MODE_PRIVATE)
    }

    var isBoardingDone: Boolean
        get() = sharedPreferences.getBoolean("isBoardingDone", false)
        set(value) = sharedPreferences.edit().putBoolean("isBoardingDone", value).apply()

}