package com.example.motionlayoutproject

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.toast(string: String) = Toast.makeText(this,string,Toast.LENGTH_SHORT).show()