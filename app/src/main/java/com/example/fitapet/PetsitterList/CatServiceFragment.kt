package com.example.fitapet.PetsitterList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentCatServiceBinding
import com.example.fitapet.databinding.FragmentDogServiceBinding
import com.example.fitapet.retrofit.RetrofitClient
import com.example.fitapet.retrofit.dto.searchPsitter
import com.example.fitapet.ui.reservation.petList.PetListRecyclerFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatServiceFragment  : Fragment() {
    private var _binding: FragmentCatServiceBinding? = null
    private val binding get() = _binding!!
    var map1 = HashMap<String, String>()
    val petsittercards= mutableListOf<PetsitterCard>()
    val CatPetsitterListAdapter=CatPetsitterListAdapter(petsittercards)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCatServiceBinding.inflate(inflater,container,false)
//        binding.petListRecyclerView.layoutManager=LinearLayoutManager(requireContext())
//        binding.petListRecyclerView.adapter= PetListAdapter(pets)

        //petsittercards.add(PetsitterCard("R.drawable.example1","김도선","10년이상","반려동물 있음","남","25","안녕하세요"))
        //petsittercards.add(PetsitterCard("R.drawable.example1","정민욱","10년이상","반려동물 있음","남","25","안녕하세요"))
        //map1.put("sex", "F")
        //map1.put("isWalkable_YN", "N")
        map1.put("careType", "CAT")

        var mp = 0
        var wp = 0
        //캣돌봄 map1 CAT추가
        map1.put("careType","CAT")
        binding.wPetsitter.setOnClickListener {
            if (wp==0){
                binding.wPetsitter.setBackgroundResource(R.drawable.blue_side_btn)
                if (mp == 1){
                    map1.remove("sex")
                }else{
                    map1.put("sex", "F")
                }
                wp=1
            }else{
                binding.wPetsitter.setBackgroundResource(R.drawable.friend_button)
                if (map1.containsKey("sex")){
                    map1.remove("sex")
                }else{
                    map1.put("sex", "M")
                }
                wp=0
            }
            apicon()
            //Log.d("apicon", map1.size.toString())
        }
        binding.mPetsitter.setOnClickListener {
            if (mp==0){
                binding.mPetsitter.setBackgroundResource(R.drawable.blue_side_btn)
                if (wp == 1){
                    map1.remove("sex")
                }else{
                    map1.put("sex", "M")
                }
                mp=1
            }else{
                binding.mPetsitter.setBackgroundResource(R.drawable.friend_button)
                if (map1.containsKey("sex")){
                    map1.remove("sex")
                }else{
                    map1.put("sex", "F")
                }
                mp=0
            }
            apicon()
        }
        var cam = 0
        binding.cameraAgree.setOnClickListener {
            if (cam==0){
                binding.cameraAgree.setBackgroundResource(R.drawable.blue_side_btn)
                map1.put("isAgreeToFilm_YN", "Y")
                cam=1
            }else{
                binding.cameraAgree.setBackgroundResource(R.drawable.friend_button)
                map1.remove("isAgreeToFilm_YN")
                cam=0
            }
            apicon()
        }
        var loc = 0
        binding.locationAgree.setOnClickListener {
            if (loc==0){
                binding.locationAgree.setBackgroundResource(R.drawable.blue_side_btn)
                map1.put("isAgreeSharingLocation_YN", "Y")
                loc=1
            }else{
                binding.locationAgree.setBackgroundResource(R.drawable.friend_button)
                map1.remove("isAgreeSharingLocation_YN")
                loc=0
            }
            apicon()
        }
        var own = 0
        binding.havePet.setOnClickListener {
            if (own==0){
                binding.havePet.setBackgroundResource(R.drawable.blue_side_btn)
                map1.put("hasPet_YN", "Y") //Query Key값 확인
                own=1
            }else{
                binding.havePet.setBackgroundResource(R.drawable.friend_button)
                map1.remove("hasPet_YN")
                own=0
            }
            apicon()
        }

        apicon()

        binding.recylcerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recylcerView.adapter=CatPetsitterListAdapter
        CatPetsitterListAdapter.setItemClickListener(object : CatPetsitterListAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                loadFragment(PetListRecyclerFragment())
            }

        })

        return binding.root
    }

    fun apicon(){
        RetrofitClient.apiServer.searchPsitter(4, map1).enqueue(object: Callback<searchPsitter> {
            override fun onResponse(call: Call<searchPsitter>, response: Response<searchPsitter>) {
                petsittercards.clear()
                Log.d("iamhere", "여기있다")
                //petsittercards = response.body()!!.result as MutableList<Petsitter>
                val responseResult=response.body()!!.result
                Log.d("iamhere4", responseResult.size.toString())
                for (petsitter in responseResult){
                    Log.d("iamhere2", "여기있다2")
                    petsittercards.add(PetsitterCard(petsitter.petSitterProfileImg, petsitter.petSitterName, petsitter.career,
                        petsitter.hasPet_YN, petsitter.sex, petsitter.age, petsitter.selfIntroduction, petsitter.isAgreeToFilm_YN,
                        petsitter.isAgreeSharingLocation_YN, petsitter.isWalkable_YN, petsitter.isPossibleCareOldPet_YN, petsitter.satisfaction,
                        petsitter.veterinarianName, petsitter.veterinarianImgUrl, petsitter.isBookMark))
                }

                Log.d("iamhere3", petsittercards.size.toString())
                binding.recylcerView.adapter=CatPetsitterListAdapter
            }

            override fun onFailure(call: Call<searchPsitter>, t: Throwable) {
                Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun loadFragment(fragment: Fragment){
        Log.d("clickTest","click!->"+fragment.tag)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}