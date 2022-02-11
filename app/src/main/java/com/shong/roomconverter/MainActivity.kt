package com.shong.roomconverter

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shong.roomconverter.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = this::class.java.simpleName+"_sHong"

    private val binding by lazy{ ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        makeObserver()

        binding.run {
            insertDataButton.setOnClickListener {
                val map = try {
                    val id = idEditText.text.toString().toInt()
                    val data = ExampleModel(
                        user = User(name = "sHong", americanAge = 28),
                        timeMillis = System.currentTimeMillis(),
                        friend = null,
                        contact = Contact(email = "ksh7512@gmail.com", phone = null)
                    )

                    mapOf(id to data)
                }catch (e: Exception){
                    Log.d(TAG,"[InserButton]Id and Data Error: $e")
                    return@setOnClickListener
                }finally {
                    idEditText.setText("")
                }

                viewModel.insertExampleEntity(map)
            }
            selectDataButton.setOnClickListener {
                val id = try {
                    idEditText.text.toString().toInt()
                }catch (e: Exception){
                    Log.d(TAG,"[SelectButton]Id Error: $e")
                    return@setOnClickListener
                }finally {
                    idEditText.setText("")
                }
                viewModel.selectExampleEntity(id)
            }
            getAllDataButton.setOnClickListener { viewModel.getAllExampleEntity() }
            nukeDataButton.setOnClickListener { viewModel.nukeExampleEntity() }
        }

    }

    private fun makeObserver(){
        viewModel.insertUpdateCuOk.observe(this,{
            it?.let { Log.d(TAG,"Insert Or Update $it") }
        })
        viewModel.selectExampleEntityLD.observe(this, {
            it?.let { Log.d(TAG,"id -> ${it.id} data -> ${it.exampleModel}") }
        })
        viewModel.getAllExampleEntityLD.observe(this, {
            it?.let {
                for (id in it.keys) Log.d(TAG, "id -> $id data -> ${it[id]}")
            }
        })
        viewModel.nukeExampleEntityLD.observe(this, {
            it?.let { Log.d(TAG,"Nuke DB $it") }
        })
    }
}