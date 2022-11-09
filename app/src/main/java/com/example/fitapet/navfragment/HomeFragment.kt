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
import com.example.fitapet.PetsitterList.TogetherServiceDetail.TogetherServiceFragment
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentHomeBinding

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

        reviewscards.add(ReviewCard("R.drawable.uk","정민욱","보내주신 영상 보니까 강아지랑 정말 잘 놀아주시더라구요 ㅠㅠ 우리 똘이 표정보면 똘이한테 잘 해주신게 느껴지더라구요 ㅠㅠㅎㅎㅎㅎ","R.drawable.example1","강아지돌봄","이찬수"))
        reviewscards.add(ReviewCard("R.drawable.doseon_kim02","김도선","마음 놓고 밖에 갔다올 수 있었어요","R.drawable.example1","고양이돌봄","김동근"))
        reviewscards.add(ReviewCard("R.drawable.example1","박희원","기대했던것보다 훨씬 친절","R.drawable.example1","강아지돌봄","이찬혁"))
        reviewscards.add(ReviewCard("R.drawable.example1","정원준","고양이가 좋아하더라구요","R.drawable.example1","고양이돌봄","정민욱"))
        reviewscards.add(ReviewCard("R.drawable.example1","김도현","가성비 최고에요","R.drawable.example1","강아지돌봄","김도선"))
        reviewscards.add(ReviewCard("R.drawable.example1","김도원","친구","R.drawable.example1","고양이돌봄","정민욱"))

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

        binding.togetherServices.setOnClickListener {
            loadFragment(TogetherServiceFragment())
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
