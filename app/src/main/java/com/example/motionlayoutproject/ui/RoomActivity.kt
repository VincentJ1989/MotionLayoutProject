package com.example.motionlayoutproject.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.motionlayoutproject.R
import com.example.motionlayoutproject.data.DBManager
import com.example.motionlayoutproject.extension.toast
import com.example.motionlayoutproject.viewmodel.RoomViewModel
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.coroutines.*

class RoomActivity : AppCompatActivity() {
    private val viewModel by lazy {
        RoomViewModel(DBManager.getUserRepository(this))
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

        // 使用LiveData来更新
        viewModel.list.observe(this){
            toast("查到${it.size}人")
        }
    }

    suspend fun multTask() {
        // 内部协程一个fail就取消整个scope
        coroutineScope {

        }
        // 内部协程失败了不影响其他的
        supervisorScope {
            launch {
                delay(1000)
                Log.d("TTTT","launch")
            }
            async {
                delay(3000)
                Log.d("TTTT","async")
            }
        }

        Log.d("TTTT","main")
    }

}