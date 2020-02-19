package com.example.motionlayoutproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        main_tv.apply {
            text = resources.getQuantityString(R.plurals.option_text,1,1)
            setOnClickListener {
                text = resources.getQuantityString(R.plurals.option_text,0,7)
            }
        }
    }
}
