package com.shong.roomconverter.ui

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shong.roomconverter.repository.ExampleRepository
import com.shong.roomconverter.db.example.ExampleEntity
import com.shong.roomconverter.model.ExampleModel
import com.shong.roomconverter.util.MillisConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ExampleRepository, app : Application) : AndroidViewModel(app) {
    private val TAG = this::class.java.simpleName+"_sHong"

    @Inject lateinit var millisConverter: MillisConverter
    val titleText: ObservableField<String> = ObservableField("<Room Converter Example>")
    val resultText: ObservableField<String> = ObservableField("")
    val idText: ObservableField<String> = ObservableField("")
    val nameText: ObservableField<String> = ObservableField("")

    fun insert(){
        val idBuf = idText.get() ?: return
        try {
            insertExampleEntity(idBuf.toInt(),nameText.get() ?: "<NoName>", System.currentTimeMillis())
        } catch (e: Exception) {
            resultText.set("[InsertButton] ${e.localizedMessage}")
            Log.d(TAG, "[InsertButton] Id Error: $e")
        } finally {
            idText.set("")
            nameText.set("")
        }
    }

    fun update(){
        val idBuf = idText.get() ?: return
        try {
            updateExampleEntity(idBuf.toInt(),nameText.get() ?: "<NoName>", System.currentTimeMillis())
        } catch (e: Exception) {
            resultText.set("[InsertButton] ${e.localizedMessage}")
            Log.d(TAG, "[InsertButton] Id Error: $e")
        } finally {
            idText.set("")
            nameText.set("")
        }
    }

    fun getAllData(){
        viewModelScope.launch{
            try{
                val items = repository.getAllExampleEntity()

                var str = "<DB>\n"
                for (ex in items)
                    str += "[id: ${ex.id} name: ${ex.exampleModel.name} ${millisConverter.millisToTime(ex.exampleModel.timeMillis)}]\n"
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
                repository.nukeExampleEntity()
                resultText.set("[NukeEx] All Clear Ok")
            }catch (e: Exception){
                resultText.set("[NukeEx] ${e.localizedMessage}")
                Log.d(TAG, "[NukeEx] $e")
            }
        }
    }

    internal val goExSecondLD: MutableLiveData<Unit> = MutableLiveData()
    fun goExampleSecond(){
        goExSecondLD.value = Unit
    }

    private fun insertExampleEntity(id: Int, name: String, millis: Long){
        viewModelScope.launch{
            val ex = ExampleEntity(id, ExampleModel(name = name, timeMillis=millis, null, null))
            try{
                repository.insertExampleEntity(ex)
                resultText.set("[InsertEx] Insert Data Ok")
            }catch (e: Exception){
                resultText.set("[InsertEx] ${e.localizedMessage}")
                Log.d(TAG, "[InsertEx] $e")
            }
        }
    }

    private fun updateExampleEntity(id: Int, name: String, millis: Long){
        viewModelScope.launch{
            val ex = ExampleEntity(id, ExampleModel(name = name, timeMillis=millis, null, null))
            try{
                repository.updateExampleEntity(ex)
                resultText.set("[InsertEx] Insert Data Ok")
            }catch (e: Exception){
                resultText.set("[InsertEx] ${e.localizedMessage}")
                Log.d(TAG, "[InsertEx] $e")
            }
        }
    }
}