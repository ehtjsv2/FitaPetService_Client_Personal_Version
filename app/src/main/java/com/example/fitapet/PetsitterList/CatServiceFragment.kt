package com.example.fitapet.PetsitterList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentCatServiceBinding
import com.example.fitapet.databinding.FragmentDogServiceBinding
import com.example.fitapet.ui.reservation.petList.PetListRecyclerFragment

class CatServiceFragment  : Fragment() {
    private var _binding: FragmentCatServiceBinding? = null
    private val binding get() = _binding!!
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

        petsittercards.add(PetsitterCard("R.drawable.example1","김도선","10년이상","반려동물 있음","남","25","안녕하세요"))
        petsittercards.add(PetsitterCard("R.drawable.example1","정민욱","10년이상","반려동물 있음","남","25","안녕하세요"))
        binding.recylcerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recylcerView.adapter=CatPetsitterListAdapter
        CatPetsitterListAdapter.setItemClickListener(object : CatPetsitterListAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                loadFragment(PetListRecyclerFragment())
            }

        })

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