package com.shong.roomconverter.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.shong.roomconverter.R
import com.shong.roomconverter.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vm = ViewModelProvider(this@MainActivity)[MainViewModel::class.java]
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            example = vm
            lifecycleOwner = this@MainActivity
        }

        vm.goExSecondLD.observe(this, Observer{
            startActivity(Intent(this, MainActivity2::class.java))
        })
    }
}