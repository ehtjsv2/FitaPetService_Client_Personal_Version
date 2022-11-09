package com.example.fitapet.PetsitterList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitapet.navfragment.FriendListAdapter
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentChooseFriendBinding
import com.example.fitapet.databinding.FragmentFriendBinding
import com.example.fitapet.navfragment.FriendCard
import com.example.fitapet.ui.reservation.petList.PetListRecyclerFragment

class ChooseFriendFragment : Fragment() {
    private var _binding: FragmentChooseFriendBinding? = null
    private val binding get() = _binding!!
    val friendcards= mutableListOf<FriendCard>()
    val chooseFriendAdapter= ChooseFriendAdapter(friendcards)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseFriendBinding.inflate(inflater,container,false)
//        var actionBar = (activity as MainActivity?)!!.supportActionBar
//        actionBar?.setTitle("친구 목록")
        //actionBar?.setCustomView(R.id.menu_friend)

//        binding.petListRecyclerView.layoutManager=LinearLayoutManager(requireContext())
//        binding.petListRecyclerView.adapter= PetListAdapter(pets)

        friendcards.add(FriendCard("R.drawable.example1","김도선","이메일@knu.ac.kr",))
        friendcards.add(FriendCard("R.drawable.example1","정민욱","이메일@knu.ac.kr",))
        friendcards.add(FriendCard("R.drawable.example1","김도선","이메일@knu.ac.kr",))
        friendcards.add(FriendCard("R.drawable.example1","정민욱","이메일@knu.ac.kr",))


        binding.friendChooseRecyclerview.layoutManager= LinearLayoutManager(requireContext())
        binding.friendChooseRecyclerview.adapter=chooseFriendAdapter
        chooseFriendAdapter.setItemClickListener(object : ChooseFriendAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
//             loadFragment(PetListRecyclerFragment())
            }

        })

        binding.goNextPage.setOnClickListener {
//            loadFragment(TogetherServiceFragment())
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