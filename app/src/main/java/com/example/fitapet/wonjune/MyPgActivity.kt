package com.example.fitapet.wonjune

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import com.example.fitapet.MainActivity
import com.example.fitapet.R
import com.example.fitapet.databinding.ActivityMyPgBinding

class MyPgActivity : AppCompatActivity() {
    lateinit var btnLoc : Button
    lateinit var btnVideo : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE) //타이틀바 없애기
        setContentView(R.layout.activity_my_pg)
        btnLoc = findViewById<Button>(R.id.getLoc)
        btnVideo = findViewById<Button>(R.id.getVideo)
//
        btnVideo.setOnClickListener {
            var intent = Intent(applicationContext, MaiActivity::class.java)
            startActivity(intent)
        }
        btnLoc.setOnClickListener {
            var intent = Intent(applicationContext, MapActivity::class.java)
            startActivity(intent)
        }

    }
}