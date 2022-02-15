package com.shong.roomconverter.repository

import com.shong.roomconverter.db.example.ExampleDao
import com.shong.roomconverter.db.example.ExampleEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExampleRepository constructor(
    private val exampleDao: ExampleDao
): Repository {
    override val TAG = this::class.java.simpleName + "_sHong"

    suspend fun insertExampleEntity(ex: ExampleEntity){
        withContext(Dispatchers.IO){
            exampleDao.insertEx(ex)
        }
    }

    suspend fun updateExampleEntity(ex: ExampleEntity){
        withContext(Dispatchers.IO){
            exampleDao.updateEx(ex)
        }
    }

    suspend fun selectExampleEntity(id: Int): ExampleEntity {
        val result: ExampleEntity
        withContext(Dispatchers.IO){
            result = exampleDao.selectEx(id)
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