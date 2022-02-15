package com.shong.roomconverter.db.example2

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.shong.roomconverter.db.example2.ExampleEntity2

@Dao
interface ExampleDao2 {

    @Insert
    suspend fun insertEx2(vararg ex: ExampleEntity2)

    @Update
    suspend fun updateEx2(vararg ex: ExampleEntity2)

    @Query("SELECT * FROM Example2 ORDER BY id2 DESC")
    suspend fun getAllEx2(): List<ExampleEntity2>

    @Query("SELECT * FROM Example2 WHERE id2 = :id2")
    suspend fun selectEx2(id2: Int) : ExampleEntity2

    @Query("DELETE FROM Example")
    suspend fun nukeExDB2()

}