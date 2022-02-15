package com.shong.roomconverter.db.example

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.shong.roomconverter.model.ExampleModel

class ExampleConverters {
    companion object{
        @JvmStatic
        @TypeConverter
        fun exampleModelToJson(value: ExampleModel?) = Gson().toJson(value)

        @JvmStatic
        @TypeConverter
        fun jsonToExampleModel(value: String) = Gson().fromJson(value, ExampleModel::class.java)
    }

}