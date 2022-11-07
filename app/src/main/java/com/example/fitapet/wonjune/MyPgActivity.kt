package com.example.fitapet.wonjune

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitapet.Cookie
import com.example.fitapet.MainActivity
import com.example.fitapet.R
import com.example.fitapet.databinding.ActivityLoginBinding.inflate
import com.example.fitapet.databinding.ActivityMyPgBinding
import com.example.fitapet.databinding.FragmentPetListRecyclerBinding
import com.example.fitapet.retrofit.RetrofitClient.apiServer
import com.example.fitapet.retrofit.dto.getCurrentServiceDTO
import com.example.fitapet.retrofit.dto.getPetsDTO
import com.example.fitapet.ui.reservation.petList.PetListAdapter
import com.example.fitapet.ui.reservation.petList.Pets
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPgActivity : AppCompatActivity() {
//    lateinit var btnLoc : Button
//    lateinit var btnVideo : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 액션바 왼쪽에 버튼 만들기(defalut:뒤로가기버튼)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_home_black_24dp)
        supportActionBar?.setTitle("진행중인 서비스")
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE) //타이틀바 없애기
        val responseGetCurrentService=apiServer.getCurrentService(Cookie.cookie.toString())

        val binding = ActivityMyPgBinding.inflate(layoutInflater)

        responseGetCurrentService.enqueue(object : Callback<getCurrentServiceDTO> {
            override fun onResponse(
                call: Call<getCurrentServiceDTO>,
                response: Response<getCurrentServiceDTO>
            ) {
                Log.d(ContentValues.TAG, "성공 : ${response.raw()}")
                Log.d("getCurrentService", response.body()!!.isSuccess)
                Log.d("getCurrentService", response.body()!!.code.toString())
                Log.d("getCurrentService", response.body()!!.result.toString())


                val responseResult=response.body()!!.result
                Log.d("getCurrentService", responseResult.toString())
                binding.txtView1.text=responseResult.petSitterName+" 펫시터"
                binding.txtView3.text=responseResult.planStartTime
                binding.txtView5.text=responseResult.planStartTime
                binding.editRequest.text=responseResult.customerRequestContent
//                for (pet in targetPets)
////                  val petName:String,val petBreed:String, val petBirth:String,val petSize
//                    pets.add(Pets(pet.petName,pet.petSpecies,pet.petBirth,pet.petSize))

//
//                binding.petListRecyclerView.layoutManager= LinearLayoutManager(requireContext())
//                binding.petListRecyclerView.adapter= PetListAdapter(pets)
            }

            override fun onFailure(call: Call<getCurrentServiceDTO>, t: Throwable) {
                Log.d("getCurrentService",t.toString())
            }
        })
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE) //타이틀바 없애기
        setContentView(binding.root)
//        btnLoc = findViewById<Button>(R.id.getLoc)
//        btnVideo = findViewById<Button>(R.id.getVideo)
//

        binding.getVideo.setOnClickListener {
            var intent = Intent(applicationContext, MaiActivity::class.java)
            startActivity(intent)
        }
        binding.getLoc.setOnClickListener {
            var intent = Intent(applicationContext, MapActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
        super.onBackPressed()
    }
    override fun onSupportNavigateUp(): Boolean {
        Log.d("actionbar","onSupportNabigateUp")
        val intent=Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
        return super.onSupportNavigateUp()
    }
}