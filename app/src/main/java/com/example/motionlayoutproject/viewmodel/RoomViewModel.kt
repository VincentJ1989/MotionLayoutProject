package com.example.motionlayoutproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.motionlayoutproject.data.UserRepository
import kotlinx.coroutines.launch

class RoomViewModel(val repo: UserRepository) : ViewModel() {
    fun insert3User() {
        viewModelScope.launch {
            repo.insert3User()
        }
    }

    fun getAll() {
        viewModelScope.launch {
            repo.getAll()
        }
    }

    fun queryOne() {
        viewModelScope.launch {
            repo.queryOn()
        }
    }

    fun update() {
        viewModelScope.launch {
            repo.update()
        }
    }

    fun delete() {
        viewModelScope.launch {
            repo.delete()
        }
    }
}