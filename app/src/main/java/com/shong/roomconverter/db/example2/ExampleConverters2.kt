package com.shong.roomconverter.db.example2

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.shong.roomconverter.model.ExampleModel

class ExampleConverters2 {
    companion object{
        @JvmStatic
        @TypeConverter
        fun listStringToJson(value: List<String>): String= Gson().toJson(value)

        @JvmStatic
        @TypeConverter
        fun jsonToListString(value: String): List<String> =
            Gson().fromJson(value, object : TypeToken<List<String>>() {}.type)
    }
}