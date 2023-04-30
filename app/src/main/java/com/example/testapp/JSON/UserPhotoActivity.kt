package com.example.testapp.JSON

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.Observer
import com.example.testapp.R

class UserPhotoActivity : AppCompatActivity() {
    val viewModel by viewModels<MyViewModel>()
    lateinit var textview: AppCompatTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_photo)
        Log.e("UserPhotoActivity", "Oncreate")
        textview = findViewById(R.id.text)
        findViewById<Button>(R.id.Abc).setOnClickListener {
            viewModel.getAPIData()
            viewModel.jsonphotdata.observe(this, Observer {
                Log.e("List", "Arraysize:" + it.toString())
                textview.text = it.asList().toString()
            })

        }

    }
}