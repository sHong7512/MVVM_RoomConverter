package com.shong.roomconverter.db.example2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.shong.roomconverter.model.ExampleModel

@Entity(tableName = "Example2")
data class ExampleEntity2(

    @PrimaryKey
    @ColumnInfo(name = "id2")
    val id: Int,

    @ColumnInfo(name = "ExampleModel2")
    @TypeConverters
    val stringList: List<String>

)
