package com.example.fitapet.PetsitterList

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fitapet.R
import com.example.fitapet.databinding.PetItemMainBinding
import com.example.fitapet.databinding.DogServiceListBinding
import com.example.fitapet.databinding.TogetherServiceListBinding
import com.example.fitapet.ui.reservation.petList.PetListAdapter

class TogetherServiceAdapter(val petsittercard:MutableList<PetsitterCard>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class MyViewHolder(val binding: TogetherServiceListBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TogetherServiceAdapter.MyViewHolder(
            TogetherServiceListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as TogetherServiceAdapter.MyViewHolder).binding
        //binding.petsitterImage.setImageResource(R.drawable.example1)
        Glide.with(holder.itemView).load(petsittercard[position].img).into(binding.petsitterImage)
        binding.petsitterName.text=petsittercard[position].name
        binding.heartRate.text=petsittercard[position].satisfaction.toString()
        binding.petsitterCareer.text=petsittercard[position].career.toString()+"년"
        binding.petsitterHavePet.text=petsittercard[position].havepet
        binding.petsitterGender.text=petsittercard[position].gender
        /*if (petsittercard[position].gender == "F"){
            binding.petsitterGender.text = "여"
        }else{
            binding.petsitterGender.text = "남"
        }*/
        binding.petsitterAge.text=petsittercard[position].age+"세"
        var strimg2 = petsittercard[position].doctorImg
        Glide.with(holder.itemView).load(strimg2).into(binding.doctorImg)
        binding.doctername.text=petsittercard[position].doctorName+" 수의사"
        binding.PetsitterText.text=petsittercard[position].petsitterText
        Glide.with(holder.itemView).load(petsittercard[position].doctorImg).into(binding.doctorImg)
        binding.doctername.text=petsittercard[position].doctorName
        if (petsittercard[position].isAgreeToFilm_YN == "Y"){
            binding.camera.text = "촬영 동의"
        }else{
            binding.camera.text = "촬영 불가"
        }

        if (petsittercard[position].isWalkable_YN == "Y"){
            binding.takeawalk.text = "산책 가능"
        }else{
            binding.takeawalk.text = "산책 불가능"
        }

        if (petsittercard[position].isAgreeSharingLocation_YN == "Y"){
            binding.location.text = "위치 공유 동의"
        }else{
            binding.location.text = "위치 공유 불가"
        }

        if (petsittercard[position].isPossibleCareOldPet_YN == "Y"){
            binding.olddog.text = "노견 케어 가능"
        }else{
            binding.olddog.text = "노견 케어 불가"
        }

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    private lateinit var itemClickListener : OnItemClickListener

    override fun getItemCount(): Int {
        return petsittercard.size
    }
}