package com.example.fitapet.wonjune

import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.example.fitapet.PetsitterList.EvaluateCard
import com.example.fitapet.R
import com.example.fitapet.databinding.ActivityServiceEvaluatePageBinding

class ServiceEvaluatePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityServiceEvaluatePageBinding.inflate(layoutInflater)
        binding.petsitterImage.setImageResource(R.drawable.example1)
        //Glide.with(this).load("url").into(binding.petsitterImage)
        binding.PetsitterText.text="안녕하세요"

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        binding.good.setOnClickListener {
            val dlg=CustomReviewDialog(this)
            dlg.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
            dlg.setCancelable(false)
            dlg.show()
            dlg.window?.setLayout(1000,WindowManager.LayoutParams.WRAP_CONTENT)
        }
        binding.bad.setOnClickListener {
            val dlg=CustomReviewDialog(this)
            dlg.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
            dlg.setCancelable(false)
            dlg.show()
        }

        setContentView(binding.root)
    }
}