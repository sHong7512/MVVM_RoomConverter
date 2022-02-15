package com.shong.roomconverter.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shong.roomconverter.db.example.ExampleConverters
import com.shong.roomconverter.db.example.ExampleDao
import com.shong.roomconverter.db.example2.ExampleDao2
import com.shong.roomconverter.db.example.ExampleEntity
import com.shong.roomconverter.db.example2.ExampleConverters2
import com.shong.roomconverter.db.example2.ExampleEntity2

@Database(entities = [ExampleEntity::class, ExampleEntity2::class], version = 1, exportSchema = false)
@TypeConverters(
    value = [ExampleConverters::class, ExampleConverters2::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao
    abstract fun exampleDao2(): ExampleDao2

    companion object {
        const val DATABASE_NAME = "roomconvertor.db"
    }
}