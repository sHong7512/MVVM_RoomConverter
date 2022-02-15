package com.shong.roomconverter.ui

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.shong.roomconverter.db.example2.ExampleEntity2
import com.shong.roomconverter.repository.ExampleRepository2
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel2 @Inject constructor(private val repository: ExampleRepository2, app : Application) : AndroidViewModel(app) {
    private val TAG = this::class.java.simpleName+"_sHong"

    val titleText: ObservableField<String> = ObservableField("<Room Converter Example2>")
    val resultText: ObservableField<String> = ObservableField("")
    val idText: ObservableField<String> = ObservableField("")
    val strText1: ObservableField<String> = ObservableField("")
    val strText2: ObservableField<String> = ObservableField("")

    fun insert(){
        val idBuf = idText.get() ?: return
        try {
            insertExampleEntity(idBuf.toInt(),strText1.get() ?: "<NoStr>", strText2.get() ?: "<NoStr>")
        } catch (e: Exception) {
            resultText.set("[InsertButton] ${e.localizedMessage}")
            Log.d(TAG, "[InsertButton] Id Error: $e")
        } finally {
            idText.set("")
            strText1.set("")
            strText2.set("")
        }
    }

    fun update(){
        val idBuf = idText.get() ?: return
        try {
            updateExampleEntity(idBuf.toInt(),strText1.get() ?: "<NoStr>", strText2.get() ?: "<NoStr>")
        } catch (e: Exception) {
            resultText.set("[InsertButton] ${e.localizedMessage}")
            Log.d(TAG, "[InsertButton] Id Error: $e")
        } finally {
            idText.set("")
            strText1.set("")
            strText2.set("")
        }
    }

    fun getAllData(){
        viewModelScope.launch{
            try{
                val items = repository.getAllExampleEntity2()

                var str = "<DB>\n"
                for (ex2 in items)
                    str += "[id: ${ex2.id} strList: ${ex2.stringList}]\n"
                resultText.set(str)

            }catch (e: Exception){
                resultText.set("[GetAllEx] ${e.localizedMessage}")
                Log.d(TAG, "[GetAllEx] $e")
            }
        }
    }

    fun nukeData(){
        viewModelScope.launch{
            try{
                repository.nukeExampleEntity2()
                resultText.set("[NukeEx] All Clear Ok")
            }catch (e: Exception){
                resultText.set("[NukeEx] ${e.localizedMessage}")
                Log.d(TAG, "[NukeEx] $e")
            }
        }
    }

    private fun insertExampleEntity(id: Int, str1: String, str2: String){
        viewModelScope.launch{
            val ex2 = ExampleEntity2(id, listOf(str1,str2))
            try{
                repository.insertExampleEntity2(ex2)
                resultText.set("[InsertEx] Insert Data Ok")
            }catch (e: Exception){
                resultText.set("[InsertEx] ${e.localizedMessage}")
                Log.d(TAG, "[InsertEx] $e")
            }
        }
    }

    private fun updateExampleEntity(id: Int, str1: String, str2: String){
        viewModelScope.launch{
            val ex2 = ExampleEntity2(id, listOf(str1,str2))
            try{
                repository.updateExampleEntity2(ex2)
                resultText.set("[InsertEx] Insert Data Ok")
            }catch (e: Exception){
                resultText.set("[InsertEx] ${e.localizedMessage}")
                Log.d(TAG, "[InsertEx] $e")
            }
        }
    }
}