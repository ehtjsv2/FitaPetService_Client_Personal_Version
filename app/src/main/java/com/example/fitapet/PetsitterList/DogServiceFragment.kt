package com.example.fitapet.PetsitterList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentDogServiceBinding

class DogServiceFragment : Fragment() {
    private lateinit var binding: FragmentDogServiceBinding
//    private val petsitterAdapter = PetsitterAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentHomeBidning = FragmentDogServiceBinding.bind(view)
        binding = fragmentHomeBidning
//        binding.itemRecyclerView.layoutManager = LinearLayoutManager(context)
//        binding.itemRecyclerView.adapter = PetsitterAdapter
    }
}