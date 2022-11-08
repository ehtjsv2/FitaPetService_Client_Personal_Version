package com.example.fitapet.PetsitterList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentDogServiceBinding
import com.example.fitapet.databinding.FragmentReviewPageBinding
import com.example.fitapet.navfragment.ReviewDetailAdapter
import com.example.fitapet.ui.reservation.petList.PetListRecyclerFragment

class ReviewPageFragment : Fragment() {
    private var _binding: FragmentReviewPageBinding? = null
    private val binding get() = _binding!!
    val reviewDetailCards= mutableListOf<ReviewDetailCard>()
    val reviewDetailAdapter=ReviewDetailAdapter(reviewDetailCards)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReviewPageBinding.inflate(inflater,container,false)
//        binding.petListRecyclerView.layoutManager=LinearLayoutManager(requireContext())
//        binding.petListRecyclerView.adapter= PetListAdapter(pets)

        reviewDetailCards.add(ReviewDetailCard("R.drawable.example1","김도선","R.drawable.example1","굿굿굿","R.drawable.example1","강아지돌봄","정민욱"))
        reviewDetailCards.add(ReviewDetailCard("R.drawable.example1","정민욱","R.drawable.example1","아주 좋아요","R.drawable.example1","고양이돌봄","김도선"))
        reviewDetailCards.add(ReviewDetailCard("R.drawable.example1","김도선","R.drawable.example1","굿굿굿","R.drawable.example1","함께돌봄","정민욱"))
        reviewDetailCards.add(ReviewDetailCard("R.drawable.example1","정민욱","R.drawable.example1","아주 좋아요","R.drawable.example1","고양이돌봄","김도선"))
        binding.reviewPageRecylcerView.layoutManager=LinearLayoutManager(requireContext())
        binding.reviewPageRecylcerView.adapter=reviewDetailAdapter
        reviewDetailAdapter.setItemClickListener(object : ReviewDetailAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
//                loadFragment(PetListRecyclerFragment())
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