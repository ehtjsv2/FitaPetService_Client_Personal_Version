package com.example.fitapet.ui.reservation.petList

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitapet.MainActivity
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentPetListRecyclerBinding
import com.example.fitapet.databinding.FragmentReservation01Binding
import com.example.fitapet.retrofit.dto.getPetsDTO
import com.example.fitapet.ui.reservation.Reservation01Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [PetListRecyclerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PetListRecyclerFragment : Fragment() {
    private var _binding: FragmentPetListRecyclerBinding? = null
    private val binding get() = _binding!!
    lateinit var parentActivity:Activity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val getPetsResponse=apiServer.retrieveUserAddress("4")

        _binding = FragmentPetListRecyclerBinding.inflate(inflater,container,false)
        val pets = mutableListOf<Pets>()
        pets.add(Pets("토토","말티즈","2012년10월","대"))
        pets.add(Pets("까망이","도베르만","2011년07월","대"))
        binding.petListRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.petListRecyclerView.adapter=PetListAdapter(pets)

        binding.reservation00NextBtn.setOnClickListener{
            loadFragment(Reservation01Fragment())
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
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()

    }

}