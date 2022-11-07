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
import com.example.fitapet.databinding.FragmentFriendBinding
import com.example.fitapet.databinding.FriendListBinding
import com.example.fitapet.navfragment.FriendCard
import com.example.fitapet.navfragment.FriendFragment

class FriendListAdapter(val friendcard:MutableList<FriendCard>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class MyViewHolder(val binding: FriendListBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FriendListAdapter.MyViewHolder(
            FriendListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as FriendListAdapter.MyViewHolder).binding
        binding.FriendImage.setImageResource(R.drawable.example1)
        binding.FriendName.text=friendcard[position].friendName
        binding.FriendEmail.text=friendcard[position].firendEmail
//        holder.itemView.setOnClickListener {
//            itemClickListener.onClick(it, position)
//        }
    }
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    private lateinit var itemClickListener : OnItemClickListener

    override fun getItemCount(): Int {
        return friendcard.size
    }
}
