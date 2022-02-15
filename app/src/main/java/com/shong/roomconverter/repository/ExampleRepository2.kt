package com.shong.roomconverter.repository

import com.shong.roomconverter.db.example2.ExampleDao2
import com.shong.roomconverter.db.example2.ExampleEntity2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExampleRepository2 constructor(
    private val exampleDao2: ExampleDao2
): Repository {
    override val TAG = this::class.java.simpleName + "_sHong"

    suspend fun insertExampleEntity2(ex: ExampleEntity2){
        withContext(Dispatchers.IO){
            exampleDao2.insertEx2(ex)
        }
    }

    suspend fun updateExampleEntity2(ex: ExampleEntity2){
        withContext(Dispatchers.IO){
            exampleDao2.updateEx2(ex)
        }
    }

    suspend fun selectExampleEntity2(id: Int): ExampleEntity2 {
        val result: ExampleEntity2
        withContext(Dispatchers.IO){
            result = exampleDao2.selectEx2(id)
        }
        return result
    }

    suspend fun getAllExampleEntity2(): List<ExampleEntity2>{
        val result: List<ExampleEntity2>
        withContext(Dispatchers.IO){
            result = exampleDao2.getAllEx2()
        }
        return result
    }

    suspend fun nukeExampleEntity2(){
        withContext(Dispatchers.IO){
            exampleDao2.nukeExDB2()
        }
    }
}