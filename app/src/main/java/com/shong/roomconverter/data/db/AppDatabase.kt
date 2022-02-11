package com.shong.roomconverter.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shong.roomconverter.data.db.dao.ExampleDao
import com.shong.roomconverter.data.db.entity.ExampleEntity

@Database(entities = [ExampleEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exampleDao(): ExampleDao

    companion object {
        const val DATABASE_NAME = "roomconvertor.db"
    }
}