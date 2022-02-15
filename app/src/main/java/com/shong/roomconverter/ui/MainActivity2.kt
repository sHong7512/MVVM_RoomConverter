package com.shong.roomconverter.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.shong.roomconverter.R
import com.shong.roomconverter.databinding.ActivityMain2Binding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMain2Binding>(this, R.layout.activity_main2).apply {
            example2 = ViewModelProvider(this@MainActivity2)[MainViewModel2::class.java]
            lifecycleOwner = this@MainActivity2
        }
    }
}