package com.example.motionlayoutproject.data

import android.content.Context

object DBManager {
    fun getUserRepository(context: Context): UserRepository {
        return UserRepository.getInstance(
            AppDatabase.getInstance(context.applicationContext).userDao())
    }

}