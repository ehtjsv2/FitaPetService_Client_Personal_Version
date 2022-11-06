package com.example.fitapet.wonjune

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 액션바 왼쪽에 버튼 만들기(defalut:뒤로가기버튼)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_home_black_24dp)
        supportActionBar?.setTitle("진행중인 서비스")
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

    override fun onSupportNavigateUp(): Boolean {
        Log.d("actionbar","onSupportNabigateUp")
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
        return super.onSupportNavigateUp()
    }
}