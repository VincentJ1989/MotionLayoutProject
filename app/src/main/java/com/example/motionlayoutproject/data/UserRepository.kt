package com.example.motionlayoutproject.data

import android.util.Log

class UserRepository private constructor(private val userDao: UserDao) {
    private val TAG = this::class.java.simpleName

    companion object {
        // For Singleton instantiation
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(userDao: UserDao) =
            instance ?: synchronized(this) {
                instance ?: UserRepository(userDao).also { instance = it }
            }
    }

    suspend fun insert3User() {
        userDao.insert(
            User(1, "F1", "L1", 1),
            User(2, "F2", "L2", 2),
            User(3, "F3", "L3", 3)
        )
        Log.d(TAG, "插入成功3条")
    }

    suspend fun getAll() {
        Log.d(TAG, userDao.getAll().toString())
    }

    suspend fun queryOn() {
        Log.d(TAG, "查找完毕")
        Log.d(TAG, userDao.findByName("F2", "L2").toString())
        Log.d(TAG, userDao.loadFullName().toString())
    }

    suspend fun update() {
        userDao.update(User(2, "F2", "L2", 20, Address("stree", "23", "xm", 86)))
        Log.d(TAG, "更新完毕，可重新查询")
    }

    suspend fun delete() {
        userDao.delete(User(1, "L1", "L2", 1))
        Log.d(TAG, "删除完毕，可重新查询")
    }
}