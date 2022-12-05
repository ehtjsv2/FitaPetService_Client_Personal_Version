package com.example.fitapet.navfragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.fitapet.Cookie
import com.example.fitapet.PetsitterList.ProfileEditFragment
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentAddFriendDialogBinding
import com.example.fitapet.retrofit.RetrofitClient
import com.example.fitapet.retrofit.dto.addFriendDTO
import com.example.fitapet.retrofit.dto.addFriendDtoNoResult
import com.example.fitapet.retrofit.dto.registerPetDtoNoResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddFriendDialogFragment : DialogFragment() {
    private var _binding: FragmentAddFriendDialogBinding? = null
    private val binding get() = _binding!!
    lateinit var responseRegisterPet: Call<addFriendDtoNoResult>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddFriendDialogBinding.inflate(inflater, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.addButton.setOnClickListener {
            val f_email=addFriendDTO(binding.email.text.toString())
            Log.d("TAG11",binding.email.text.toString())
            responseRegisterPet=RetrofitClient.apiServer.addFriend(Cookie.userId,binding.email.text.toString())
            responseRegisterPet.enqueue(object : Callback<addFriendDtoNoResult> {
                override fun onResponse(
                    call: Call<addFriendDtoNoResult>,
                    response: Response<addFriendDtoNoResult>
                ) {

                    Log.d("TAG11","success"+response.body()?.message)

                }

                override fun onFailure(call: Call<addFriendDtoNoResult>, t: Throwable) {
                    Log.d("TAG11","fail")
                }

            })
            loadFragment(FriendFragment())
            dismiss()
        }
        return binding.root
    }

    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null
    }

    private fun loadFragment(fragment: Fragment){
        Log.d("clickTest","click!->"+fragment.tag)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}