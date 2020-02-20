package com.example.motionlayoutproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.motionlayoutproject.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomViewModel(val repo: UserRepository) : ViewModel() {
    fun insert3User() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repo.insert3User()
            }
        }
    }

    fun getAll() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repo.getAll()
            }
        }
    }

    fun queryOne() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repo.queryOn()
            }
        }
    }

    fun update() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repo.update()
            }
        }
    }

    fun delete() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repo.delete()
            }
        }
    }
}