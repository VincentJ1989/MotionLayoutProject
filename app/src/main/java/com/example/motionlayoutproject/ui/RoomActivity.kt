package com.example.motionlayoutproject.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.motionlayoutproject.R
import com.example.motionlayoutproject.data.Address
import com.example.motionlayoutproject.data.AppDatabase
import com.example.motionlayoutproject.data.User
import kotlinx.android.synthetic.main.activity_room.*
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.motionlayoutproject.data.DBManager
import com.example.motionlayoutproject.viewmodel.RoomViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomActivity : AppCompatActivity() {
    private val TAG = this::class.java.simpleName
    private val userDao by lazy {
        AppDatabase.getInstance(this).userDao()
    }

    private val viewModel by lazy {
        RoomViewModel(DBManager.getUserRepository(this))
//        ViewModelProvider.NewInstanceFactory().create(RoomViewModel::class.java)
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