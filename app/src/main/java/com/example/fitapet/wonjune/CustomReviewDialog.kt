package com.example.fitapet.wonjune

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window

import com.example.fitapet.databinding.MakeReviewDialogBinding


class CustomReviewDialog(var activity: Activity) : Dialog(activity),
    View.OnClickListener {
    val currentTime : Long = System.currentTimeMillis()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        val binding= MakeReviewDialogBinding.inflate(layoutInflater)

        // 등록하기 버튼클릭시
        binding.registBtn.setOnClickListener {
            dismiss()
        }
        // 무시하기 버튼클릭시
        binding.ignoreBtn.setOnClickListener {
            dismiss()
        }
        setContentView(binding.root)

//        yes.setOnClickListener(this)
//        no.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

}
//    override fun onClick(v: View) {
//        when (v.id) {
//            R.id.yes -> {
//            }
//            R.id.no -> dismiss()
//            else -> {
//            }
//        }//Do Something
//        dismiss()
//    }