package com.example.fitapet.wonjune

import android.content.Intent
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.example.fitapet.Cookie
import com.example.fitapet.MainActivity
import com.example.fitapet.R
import com.example.fitapet.databinding.ActivityServiceEvaluatePageBinding

class ServiceEvaluatePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding=ActivityServiceEvaluatePageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        binding.petsitterImage.setImageResource(R.drawable.example1)
        //Glide.with(this).load("url").into(binding.petsitterImage)
        binding.PetsitterText.text="안녕하세요"

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        binding.good.setOnClickListener {
            val dlg= CustomReviewDialog(this,1, Cookie.userId,"Y")
            dlg.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
            dlg.setCancelable(false)
            dlg.show()
            dlg.window?.setLayout(1000, WindowManager.LayoutParams.WRAP_CONTENT)
        }
        binding.bad.setOnClickListener {
            val dlg= CustomReviewDialog(this,1, Cookie.userId,"N")
            dlg.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
            dlg.setCancelable(false)
            dlg.show()
            dlg.window?.setLayout(1000, WindowManager.LayoutParams.WRAP_CONTENT)
        }
        setContentView(binding.root)
    }

    companion object{
        var serviceId:Long=0
    }
}