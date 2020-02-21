package com.example.motionlayoutproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.motionlayoutproject.data.UserRepository
import com.example.motionlayoutproject.extension.async

class RoomViewModel(val repo: UserRepository) : ViewModel() {
    fun insert3User() {
        async {
            repo.insert3User()
        }
    }

    fun getAll() {
        async {
            repo.getAll()
        }
    }

    fun queryOne() {
        async {
            repo.queryOn()
        }
    }

    fun update() {
        async {
            repo.update()
        }
    }

    fun delete() {
        async {
            repo.delete()
        }
    }
    // LiveData
    val list = repo.list
    // Flow 转成LiveData
    val listByFlow = repo.listByFlow.asLiveData()

}