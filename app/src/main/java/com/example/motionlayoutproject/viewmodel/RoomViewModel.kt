package com.example.motionlayoutproject.viewmodel

import androidx.lifecycle.ViewModel
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

    var list = repo.list
}