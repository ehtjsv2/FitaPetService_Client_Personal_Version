package com.example.fitapet.PetsitterList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentDogServiceBinding
import com.example.fitapet.databinding.FragmentHomeBinding
import com.example.fitapet.ui.reservation.petList.PetListAdapter

class DogServiceFragment : Fragment() {
    private var _binding: FragmentDogServiceBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDogServiceBinding.inflate(inflater,container,false)
//        binding.petListRecyclerView.layoutManager=LinearLayoutManager(requireContext())
//        binding.petListRecyclerView.adapter= PetListAdapter(pets)
        val petsittercards= mutableListOf<PetsitterCard>()
        petsittercards.add(PetsitterCard(0,0,"김도선","10년이상","있음","남","25","안녕하세요"))
        petsittercards.add(PetsitterCard(0,0,"정민욱","10년이상","있음","남","25","안녕하세요"))
        binding.recylcerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recylcerView.adapter=PetsitterListAdapter(petsittercards)
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