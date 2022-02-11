package com.shong.roomconverter.data

import android.content.Context
import com.shong.roomconverter.data.db.dao.ExampleDao
import com.shong.roomconverter.data.db.entity.ExampleEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository constructor(
    private val context: Context,
    private val exampleDao: ExampleDao
) {
    val TAG = this::class.java.simpleName

    suspend fun insertExampleEntity(cu: ExampleEntity){
        withContext(Dispatchers.IO){
            exampleDao.insertEx(cu)
        }
    }

    suspend fun updateExampleEntity(cu: ExampleEntity){
        withContext(Dispatchers.IO){
            exampleDao.updateEx(cu)
        }
    }

    suspend fun selectExampleEntity(viewSeq: Int): ExampleEntity {
        val result: ExampleEntity
        withContext(Dispatchers.IO){
            result = exampleDao.selectEx(viewSeq)
        }
        return result
    }

    suspend fun getAllExampleEntity(): List<ExampleEntity>{
        val result: List<ExampleEntity>
        withContext(Dispatchers.IO){
            result = exampleDao.getAllEx()
        }
        return result
    }

    suspend fun nukeExampleEntity(){
        withContext(Dispatchers.IO){
            exampleDao.nukeExDB()
        }
    }

}