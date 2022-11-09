package com.example.fitapet.navfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitapet.PetsitterList.ProfileEditFragment
import com.example.fitapet.PetsitterList.TogetherServiceDetail.TogetherServiceFragment
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentMypageBinding
import de.hdodenhof.circleimageview.CircleImageView

class MypageFragment : Fragment() {
    lateinit var petList: RecyclerView
    var parray = mutableListOf<MypetList>()

    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var petinfo = MypetList("체리", "치와와", "소형", "암컷", "5")
        var petinfo2 = MypetList("샤넬", "말티즈", "소형", "수컷", "2")
        var petinfo3 = MypetList("딸기", "푸들", "소형", "암컷", "4")
        _binding = FragmentMypageBinding.inflate(inflater,container,false)
        parray.add(petinfo)
        parray.add(petinfo2)
        parray.add(petinfo3)
        petList = binding.petList
        val linearLayoutManager = LinearLayoutManager(requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        petList.layoutManager = linearLayoutManager
        petList.adapter = RecyclerviewAdapter()

        _binding = FragmentMypageBinding.inflate(inflater,container,false)

        binding.editProf.setOnClickListener {
            loadFragment(ProfileEditFragment())
        }

        return binding.root
    }
    inner class RecyclerviewAdapter : RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewAdapter.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pet, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.itemImg.setImageResource(R.drawable.petimg)
            holder.itemPname.text = parray[position].name
            holder.itemKind.text = parray[position].kind
            holder.itemSize.text = parray[position].scale
            holder.itemSex.text = parray[position].sex
            holder.itemAge.text = parray[position].age
        }

        override fun getItemCount(): Int {
            return parray.size
        }

        inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
            val itemPname = view.findViewById<TextView>(R.id.textPetname)
            val itemKind = view.findViewById<TextView>(R.id.textSpecies)
            val itemSize = view.findViewById<TextView>(R.id.textScale)
            val itemSex = view.findViewById<TextView>(R.id.textSex)
            val itemAge = view.findViewById<TextView>(R.id.textAge)
            val itemImg = view.findViewById<ImageView>(R.id.pet_img)
        }

    }

    inner class RecyclerviewAdapter2 :RecyclerView.Adapter<RecyclerviewAdapter2.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewAdapter2.ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bmark, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        }

        override fun getItemCount(): Int {
            return 1
        }

        inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
            val itemPSimg = view.findViewById<CircleImageView>(R.id.sitterProfile)
            val itemPSname = view.findViewById<TextView>(R.id.sitterName)
            val itemKind = view.findViewById<TextView>(R.id.textKind)
            val itemRpon = view.findViewById<TextView>(R.id.textResponse)
            val itemRpon2 = view.findViewById<TextView>(R.id.textResponse2)
            val itemSex = view.findViewById<TextView>(R.id.textSex2)
            val itemAge = view.findViewById<TextView>(R.id.textAge2)
        }
    }

    private fun loadFragment(fragment: Fragment){
        Log.d("clickTest","click!->"+fragment.tag)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}