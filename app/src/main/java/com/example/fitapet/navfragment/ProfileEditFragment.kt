package com.example.fitapet.PetsitterList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitapet.PetsitterList.TogetherServiceDetail.TogetherServiceFragment
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentDogServiceBinding
import com.example.fitapet.databinding.FragmentProfileEditBinding
import com.example.fitapet.navfragment.MypageFragment
import com.example.fitapet.navfragment.UserProfile
import com.example.fitapet.ui.reservation.petList.PetListRecyclerFragment

class ProfileEditFragment : Fragment() {
    private var _binding: FragmentProfileEditBinding? = null
    private val binding get() = _binding!!
    val userProfile= mutableListOf<UserProfile>()
//    val petsitterListAdapter=PetsitterListAdapter(petsittercards)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileEditBinding.inflate(inflater,container,false)
//        binding.petListRecyclerView.layoutManager=LinearLayoutManager(requireContext())
//        binding.petListRecyclerView.adapter= PetListAdapter(pets)

        userProfile.add(UserProfile("R.drawable.example1","김도선","01012345678","대구광역시 북구 대현동 24-9","남자","25"))

        binding.petsitterImage.setImageResource(R.drawable.dog_service)
//        binding.myName.text=userProfile[position].userName
//        binding.myPhoneNum.editableText=userProfile[position].userPhoneNum
//        binding.myLocation.editableText=userProfile[position].userLoaction
//        binding.myGender.text=userProfile[position].userGender
//        binding.myAge.editableText=userProfile[position].userAge

//        binding.profileEdit.layoutManager=LinearLayoutManager(requireContext())
//        binding.recylcerView.adapter=petsitterListAdapter
//        petsitterListAdapter.setItemClickListener(object : PetsitterListAdapter.OnItemClickListener{
//            override fun onClick(v: View, position: Int) {
//                loadFragment(PetListRecyclerFragment())
//            }
//
//        })

        binding.done.setOnClickListener {
            loadFragment(MypageFragment())
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