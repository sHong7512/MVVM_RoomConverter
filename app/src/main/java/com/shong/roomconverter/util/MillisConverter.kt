package com.shong.roomconverter.util

import android.annotation.SuppressLint
import dagger.hilt.android.scopes.ViewModelScoped
import java.text.SimpleDateFormat
import javax.inject.Inject
import javax.inject.Singleton

@ViewModelScoped
class MillisConverter @Inject constructor(){

    @SuppressLint("SimpleDateFormat")
    fun millisToTime(mills: Long): String{
        val simpleDateFormat = SimpleDateFormat("yyyy/MM/dd hh:mm:ss")
        return simpleDateFormat.format(mills)
    }

}