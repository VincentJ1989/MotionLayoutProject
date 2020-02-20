package com.example.motionlayoutproject.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.motionlayoutproject.R
import com.example.motionlayoutproject.viewmodel.RoomViewModel
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.coroutines.*

class RoomActivity : AppCompatActivity() {
    private val viewModel by lazy {
        //      RoomViewModel(DBManager.getUserRepository(this))
        ViewModelProvider.NewInstanceFactory().create(RoomViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        initView()
    }

    private fun initView() {
        room_create_tv.setOnClickListener {
            viewModel.insert3User()
        }

        room_query_all_tv.setOnClickListener {
            viewModel.getAll()
        }

        room_query_tv.setOnClickListener {
            viewModel.queryOne()
        }

        room_update_tv.setOnClickListener {
            viewModel.update()
        }

        room_delete_tv.setOnClickListener {
            viewModel.delete()
        }
    }

}