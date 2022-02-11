package com.shong.roomconverter

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.shong.roomconverter.data.Repository
import com.shong.roomconverter.data.db.entity.ExampleEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: Repository, app : Application) : AndroidViewModel(app) {
    private val TAG = this::class.java.simpleName+"_sHong"

    internal val insertUpdateCuOk: MutableLiveData<Boolean> = MutableLiveData()
    internal fun insertExampleEntity(idMap: Map<Int, ExampleModel?>){
        viewModelScope.launch{
            var cnt = 0
            for (key in idMap.keys){
                val ex = ExampleEntity(key, idMap[key] ?: continue)
                try{
                    repository.insertExampleEntity(ex)
                    cnt ++
                }catch (e: Exception){
                    cnt += updateExampleEntity(ex)
                }
            }
            insertUpdateCuOk.value = (idMap.size == cnt)
        }
    }

    private suspend fun updateExampleEntity(ex: ExampleEntity): Int{
        try{
            repository.updateExampleEntity(ex)
            return 1
        }catch (e: Exception){
            Log.d(TAG,"[insertCU & updateCU] $e")
            return 0
        }
    }

    data class ExampleEntity_nullable(
        var id: Int,
        var exampleModel: ExampleModel?
    )
    internal val selectExampleEntityLD: MutableLiveData<ExampleEntity_nullable> = MutableLiveData()
    internal fun selectExampleEntity(id: Int){
        viewModelScope.launch{
            try{
                selectExampleEntityLD.value = ExampleEntity_nullable(id, repository.selectExampleEntity(id).exampleModel)
            }catch (e: Exception){
                Log.d(TAG,"[selectCU] $e")
                selectExampleEntityLD.value = ExampleEntity_nullable(id, null)
            }
        }
    }

    internal val getAllExampleEntityLD: MutableLiveData<MutableMap<Int, ExampleModel?>?> = MutableLiveData()
    internal fun getAllExampleEntity(){
        viewModelScope.launch{
            try{
                val items = repository.getAllExampleEntity()
                val map = mutableMapOf<Int, ExampleModel?>()
                for (i in items){
                    map.put(i.id, i.exampleModel)
                }
                getAllExampleEntityLD.value = map
            }catch (e: Exception){
                getAllExampleEntityLD.value = null
                Log.d(TAG,"[getAllCU] $e")
            }
        }
    }

    internal val nukeExampleEntityLD: MutableLiveData<Boolean> = MutableLiveData()
    internal fun nukeExampleEntity(){
        viewModelScope.launch{
            try{
                repository.nukeExampleEntity()
                nukeExampleEntityLD.value = true
            }catch (e: Exception){
                nukeExampleEntityLD.value = false
                Log.d(TAG,"[nukeCU] $e")
            }
        }
    }

}