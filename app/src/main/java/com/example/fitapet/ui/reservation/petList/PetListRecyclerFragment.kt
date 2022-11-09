package com.example.fitapet.ui.reservation.petList

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitapet.Cookie
import com.example.fitapet.MainActivity
import com.example.fitapet.PetsitterList.PetsitterListAdapter
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentPetListRecyclerBinding
import com.example.fitapet.databinding.FragmentReservation01Binding
import com.example.fitapet.retrofit.RetrofitClient.apiServer
import com.example.fitapet.retrofit.dto.getPets
import com.example.fitapet.ui.reservation.Reservation01Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PetListRecyclerFragment : Fragment() {
    private var _binding: FragmentPetListRecyclerBinding? = null
    private val binding get() = _binding!!
    val pets = mutableListOf<Pets>()
    lateinit var parentActivity:Activity
    //    val petsittercards= mutableListOf<PetsitterCard>()
//    val petsitterListAdapter=PetsitterListAdapter(petsittercards)
    val petListAdapter=PetListAdapter(pets)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //유저 '4'펫리스트 불러오기
        val responseGetPets: Call<getPets> =apiServer.getPets(4)
        //유저 Cookie.userId 펫리스트불러오기
        //val responseGetPets: Call<getPetsDTO> = apiServer.getPets(Cookie.userId)
        _binding = FragmentPetListRecyclerBinding.inflate(inflater,container,false)

        responseGetPets.enqueue(object : Callback<getPets> {
            override fun onResponse(
                call: Call<getPets>,
                response: Response<getPets>
            ) {
                Log.d(TAG, "성공 : ${response.raw()}")
                Log.d("testGetPets", response.body()!!.isSuccess)
                Log.d("testGetPets", response.body()!!.code.toString())
                Log.d("testGetPets", response.body()!!.result.toString())


                val targetPets=response.body()!!.result
                for (pet in targetPets)
//                  val petName:String,val petBreed:String, val petBirth:String,val petSize
                    pets.add(Pets(pet.petName,pet.petSpecies,pet.petBirth,pet.petSize))

                binding.petListRecyclerView.layoutManager=LinearLayoutManager(requireContext())
                binding.petListRecyclerView.adapter=petListAdapter
               // binding.petListRecyclerView.addItemDecoration(MyDecoration(requireContext()))

            }

            override fun onFailure(call: Call<getPets>, t: Throwable) {
                Log.d(TAG, "실패 : $t")
            }
        })

        //        petsitterListAdapter.setItemClickListener(object : PetsitterListAdapter.OnItemClickListener{
//            override fun onClick(v: View, position: Int) {
//                loadFragment(PetListRecyclerFragment())
//            }
//
//        })
        petListAdapter.setItemClickListener(object :PetListAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
            }

        })
        binding.reservation00NextBtn.setOnClickListener{
            loadFragment(Reservation01Fragment())
        }
        Log.d("testcode","??")


        return binding.root
    }
    private fun loadFragment(fragment: Fragment){
        Log.d("clickTest","click!->"+fragment.tag)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()

    }

}