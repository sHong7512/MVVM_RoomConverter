package com.shong.roomconverter

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BasicApp : Application() {
    private val TAG = this::class.java.simpleName+"_sHong"
}