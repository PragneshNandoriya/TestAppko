package com.example.testapp.json

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.R
import com.example.testapp.databinding.ActivityUserPhotoBinding

class UserPhotoActivity : AppCompatActivity() {
    val viewModel by viewModels<MyViewModel>()
    var adapter: AdapterJSON? = null
    lateinit var binding: ActivityUserPhotoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_photo)
        Log.e("UserPhotoActivity", "Oncreate")
        adapter = AdapterJSON()
        binding.recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.adapter = adapter
        binding.Abc.setOnClickListener {
            viewModel.getAPIData()
            viewModel.jsonphotdata.observe(this, Observer {
                Log.e("List", "Arraysize:" + it.size.toString())

                adapter?.userdatalist = it.asList()
                adapter?.notifyDataSetChanged()
            })

        }

    }
}