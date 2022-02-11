package com.shong.roomconverter.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.shong.roomconverter.model.ExampleModel

@Entity(tableName = "Example")
data class ExampleEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "ExampleModel")
    @TypeConverters
    val exampleModel: ExampleModel

)
