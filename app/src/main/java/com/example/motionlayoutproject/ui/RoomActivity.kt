package com.example.motionlayoutproject.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.motionlayoutproject.R
import com.example.motionlayoutproject.data.Address
import com.example.motionlayoutproject.data.AppDatabase
import com.example.motionlayoutproject.data.User
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : AppCompatActivity() {
    private val TAG = this::class.java.simpleName
    private val userDao by lazy {
        AppDatabase.getInstance(this).userDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        initView()
    }

    private fun initView() {
        room_create_tv.setOnClickListener {
            async {
                userDao.insertAll(
                    User(1, "F1", "L1", 1),
                    User(2, "F2", "L2", 2),
                    User(3, "F3", "L3", 3)
                )
                Log.d(TAG, "插入成功3条")
            }
        }

        room_query_all_tv.setOnClickListener {
            async {
                Log.d(TAG, userDao.getAll().toString())
            }
        }

        room_query_tv.setOnClickListener {
            async {
                Log.d(TAG, "查找完毕")
                Log.d(TAG, userDao.findByName("F2", "L2").toString())
                Log.d(TAG, userDao.loadFullName().toString())
            }
        }

        room_update_tv.setOnClickListener {
            async {
                userDao.update(User(2, "F2", "L2", 20, Address("stree", "23", "xm", 86)))
                Log.d(TAG, "更新完毕，可重新查询")
            }
        }

        room_delete_tv.setOnClickListener {
            async {
                userDao.delete(User(1, "L1", "L2", 1))
                Log.d(TAG, "删除完毕，可重新查询")
            }
        }
    }


    fun async(block: () -> Unit) {
        Thread { block.invoke() }.start()
    }
}