package com.shong.roomconverter.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.shong.roomconverter.data.db.entity.ExampleEntity

@Dao
interface ExampleDao {

    @Insert
    suspend fun insertEx(vararg ex: ExampleEntity)

    @Update
    suspend fun updateEx(vararg ex: ExampleEntity)

    @Query("SELECT * FROM Example ORDER BY id DESC")
    suspend fun getAllEx(): List<ExampleEntity>

    @Query("SELECT * FROM Example WHERE id = :id")
    suspend fun selectEx(id: Int) : ExampleEntity

    @Query("DELETE FROM Example")
    suspend fun nukeExDB()

}