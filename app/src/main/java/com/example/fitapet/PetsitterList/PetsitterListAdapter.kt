package com.example.fitapet.PetsitterList

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitapet.R
import com.example.fitapet.databinding.PetItemMainBinding
import com.example.fitapet.databinding.DogServiceListBinding
import com.example.fitapet.ui.reservation.petList.PetListAdapter

class PetsitterListAdapter(val petsittercard:MutableList<PetsitterCard>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class MyViewHolder(val binding: DogServiceListBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PetsitterListAdapter.MyViewHolder(
            DogServiceListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as PetsitterListAdapter.MyViewHolder).binding
        binding.petsitterImage.setImageResource(R.drawable.example1)
        binding.petsitterName.text=petsittercard[position].name
        binding.petsitterCareer.text=petsittercard[position].career
        binding.petsitterHavePet.text=petsittercard[position].havepet
        binding.petsitterGender.text=petsittercard[position].gender
        binding.petsitterAge.text=petsittercard[position].age
        binding.PetsitterText.text=petsittercard[position].petsitterText
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
