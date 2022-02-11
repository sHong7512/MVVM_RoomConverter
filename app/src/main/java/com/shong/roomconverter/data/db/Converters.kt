package com.shong.roomconverter.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.shong.roomconverter.ExampleModel

class Converters {
    companion object{
        @JvmStatic
        @TypeConverter
        fun listToJson(value: ExampleModel?) = Gson().toJson(value)

        @JvmStatic
        @TypeConverter
        fun jsonToList(value: String) = Gson().fromJson(value, ExampleModel::class.java)
    }

}