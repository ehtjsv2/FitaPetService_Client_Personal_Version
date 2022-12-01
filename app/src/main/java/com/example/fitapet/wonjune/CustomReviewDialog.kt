package com.example.fitapet.wonjune

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import com.example.fitapet.MainActivity
import com.example.fitapet.databinding.MakeReviewDialogBinding
import com.example.fitapet.retrofit.RetrofitClient
import com.example.fitapet.retrofit.dto.isLikeDTO
import com.example.fitapet.retrofit.dto.isLikeDtoNoResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CustomReviewDialog(var activity: Activity,val serviceId:Long?, val customerId:Long?, val like:String) : Dialog(activity),
    View.OnClickListener {
    val currentTime : Long = System.currentTimeMillis()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        lateinit var content:String
        val binding= MakeReviewDialogBinding.inflate(layoutInflater)
        lateinit var responseIsLike: Call<isLikeDtoNoResult>


        // 등록하기 버튼클릭시
        binding.registBtn.setOnClickListener {
            content=binding.content.text.toString()
            val islikedto=isLikeDTO(serviceId,customerId,like,content)
            responseIsLike= RetrofitClient.apiServer.service_is_like(islikedto)
            responseIsLike.enqueue(object : Callback<isLikeDtoNoResult>{
                override fun onResponse(
                    call: Call<isLikeDtoNoResult>,
                    response: Response<isLikeDtoNoResult>
                ) {
                    Log.d("TAG11","success")
                    //
                }

                override fun onFailure(call: Call<isLikeDtoNoResult>, t: Throwable) {
                    Log.d("TAG11","fail:"+t)
                    //(context as ServiceEvaluatePageActivity).finish()
                }

            })
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