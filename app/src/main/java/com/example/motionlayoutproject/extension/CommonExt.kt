package com.example.motionlayoutproject.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

fun ViewModel.async(block: suspend () -> Unit) {
    viewModelScope.launch {
        block.invoke()
    }
}