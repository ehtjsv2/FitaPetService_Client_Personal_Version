package com.example.fitapet.navfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitapet.PetsitterList.*
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentHomeBinding
import com.example.fitapet.databinding.FragmentPetListRecyclerBinding
import com.example.fitapet.databinding.ReviewHomeBinding
import com.example.fitapet.ui.reservation.petList.PetListRecyclerFragment

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    val reviewscards = mutableListOf<ReviewCard>()
    val reviewListAdapter=ReviewListAdapter(reviewscards)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        reviewscards.add(ReviewCard("R.drawable.example1","김도선","짱bb","R.drawable.example1","강아지돌봄","김도선"))
        reviewscards.add(ReviewCard("R.drawable.example1","정민욱","최고입니다ㅋㅋ","R.drawable.example1","고양이돌봄","정민욱"))
        reviewscards.add(ReviewCard("R.drawable.example1","김도선","짱bb","R.drawable.example1","강아지돌봄","김도선"))
        reviewscards.add(ReviewCard("R.drawable.example1","정민욱","최고입니다ㅋㅋ","R.drawable.example1","고양이돌봄","정민욱"))
        reviewscards.add(ReviewCard("R.drawable.example1","김도선","짱bb","R.drawable.example1","강아지돌봄","김도선"))
        reviewscards.add(ReviewCard("R.drawable.example1","정민욱","최고입니다ㅋㅋ","R.drawable.example1","고양이돌봄","정민욱"))

        binding.reviewRecylcerView.layoutManager= LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        binding.reviewRecylcerView.adapter=reviewListAdapter
        reviewListAdapter.setItemClickListener(object : ReviewListAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                loadFragment(ReviewPageFragment())
            }

        })

        binding.dogServices.setOnClickListener {
            loadFragment(DogServiceFragment())
        }

        binding.catServices.setOnClickListener {
            loadFragment(CatServiceFragment())
        }

        binding.reviews.setOnClickListener {
            loadFragment(ReviewPageFragment())
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
