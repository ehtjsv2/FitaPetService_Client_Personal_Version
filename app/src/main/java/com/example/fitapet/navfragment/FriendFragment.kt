package com.example.fitapet.navfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitapet.MainActivity
import com.example.fitapet.PetsitterList.FriendListAdapter
import com.example.fitapet.PetsitterList.PetsitterCard
import com.example.fitapet.PetsitterList.PetsitterListAdapter
import com.example.fitapet.R
import com.example.fitapet.navfragment.FriendFragment
import com.example.fitapet.databinding.FragmentFriendBinding
import com.example.fitapet.ui.reservation.petList.PetListRecyclerFragment

class FriendFragment : Fragment() {
    private var _binding: FragmentFriendBinding? = null
    private val binding get() = _binding!!
    val friendcards= mutableListOf<FriendCard>()
    val friendListAdapter= FriendListAdapter(friendcards)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFriendBinding.inflate(inflater,container,false)
        var actionBar = (activity as MainActivity?)!!.supportActionBar
        actionBar?.setTitle("친구 목록")
        //actionBar?.setCustomView(R.id.menu_friend)

//        binding.petListRecyclerView.layoutManager=LinearLayoutManager(requireContext())
//        binding.petListRecyclerView.adapter= PetListAdapter(pets)

        friendcards.add(FriendCard(0,0,"김도선","이메일@knu.ac.kr",))
        friendcards.add(FriendCard(0,0,"정민욱","이메일@knu.ac.kr",))
        friendcards.add(FriendCard(0,0,"김도선","이메일@knu.ac.kr",))
        friendcards.add(FriendCard(0,0,"정민욱","이메일@knu.ac.kr",))
        friendcards.add(FriendCard(0,0,"김도선","이메일@knu.ac.kr",))
        friendcards.add(FriendCard(0,0,"정민욱","이메일@knu.ac.kr",))
        friendcards.add(FriendCard(0,0,"김도선","이메일@knu.ac.kr",))
        friendcards.add(FriendCard(0,0,"정민욱","이메일@knu.ac.kr",))

        binding.friendRecyclerview.layoutManager= LinearLayoutManager(requireContext())
        binding.friendRecyclerview.adapter=friendListAdapter
        friendListAdapter.setItemClickListener(object : FriendListAdapter.OnItemClickListener{
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