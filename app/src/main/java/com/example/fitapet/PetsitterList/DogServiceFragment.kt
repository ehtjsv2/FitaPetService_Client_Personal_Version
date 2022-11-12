package com.example.fitapet.PetsitterList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.example.fitapet.PetsitterList.TogetherServiceDetail.ChooseFriendAdapter
import com.example.fitapet.PetsitterList.TogetherServiceDetail.TogetherServiceFragment
import com.example.fitapet.Cookie
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentDogServiceBinding
import com.example.fitapet.retrofit.RetrofitClient
import com.example.fitapet.retrofit.dto.Petsitter
import com.example.fitapet.retrofit.dto.searchPsitter
import com.example.fitapet.ui.reservation.petList.PetListRecyclerFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DogServiceFragment : Fragment() {
    private var _binding: FragmentDogServiceBinding? = null
    private val binding get() = _binding!!
    var map1 = HashMap<String, String>()
    var petsittercards= mutableListOf<PetsitterCard>()
    val petsitterListAdapter=PetsitterListAdapter(petsittercards)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDogServiceBinding.inflate(inflater,container,false)
//        binding.petListRecyclerView.layoutManager=LinearLayoutManager(requireContext())
//        binding.petListRecyclerView.adapter= PetListAdapter(pets)

        map1.put("sex", "F")
        map1.put("isWalkable_YN", "N")
        Log.d("iamhere", Cookie.userId.toString())
        RetrofitClient.apiServer.searchPsitter(4, map1).enqueue(object: Callback<searchPsitter>{
            override fun onResponse(call: Call<searchPsitter>, response: Response<searchPsitter>) {
                Log.d("iamhere", "여기있다")
                //petsittercards = response.body()!!.result as MutableList<Petsitter>
                val responseResult=response.body()!!.result
                for (petsitter in responseResult){
                    Log.d("iamhere2", "여기있다2")
                    petsittercards.add(PetsitterCard(petsitter.petSitterProfileImg, petsitter.petSitterName, petsitter.career,
                    petsitter.hasPet_YN, petsitter.sex, petsitter.age.toString(), petsitter.selfIntroduction, petsitter.isAgreeToFilm_YN,
                    petsitter.isAgreeSharingLocation_YN, petsitter.isWalkable_YN, petsitter.isPossibleCareOldPet_YN, petsitter.isBookMark))
                }

                Log.d("iamhere3", petsittercards.size.toString())
                binding.recylcerView.adapter=petsitterListAdapter
            }

            override fun onFailure(call: Call<searchPsitter>, t: Throwable) {
                Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
            }

        })

        //petsittercards.add(PetsitterCard("R.drawable.example1","김도선","10년이상","반려동물 있음","남","25","안녕하세요"))
        //petsittercards.add(PetsitterCard("R.drawable.example1","정민욱","10년이상","반려동물 있음","남","25","안녕하세요"))

        binding.recylcerView.layoutManager=LinearLayoutManager(requireContext())
        //binding.recylcerView.adapter=petsitterListAdapter
        petsitterListAdapter.setItemClickListener(object : PetsitterListAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                loadFragment(PetListRecyclerFragment())
            }

        })

        binding.visit.setOnClickListener {
            //loadFragment(TogetherServiceFragment())
        }

        binding.togo.setOnClickListener {
            //loadFragment(TogetherServiceFragment())
        }

        return binding.root
    }

    private fun loadFragment(fragment: Fragment){
        Log.d("clickTest","click!->"+fragment.tag)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}