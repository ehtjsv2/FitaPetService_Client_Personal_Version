package com.example.fitapet.navfragment

import android.content.Context
import android.content.Intent
import android.util.Log
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
import com.example.fitapet.databinding.ReviewHomeBinding
import com.example.fitapet.navfragment.FriendCard
import com.example.fitapet.navfragment.FriendFragment

class ReviewListAdapter(val reviewCard:MutableList<ReviewCard>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class MyViewHolder(val binding: ReviewHomeBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ReviewListAdapter.MyViewHolder(
            ReviewHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("LOGTest",""+itemCount+"---"+position)
        val binding = (holder as ReviewListAdapter.MyViewHolder).binding
        binding.parentImage.setImageResource(R.drawable.example1)
        binding.parentName.text=reviewCard[position].parentName
        binding.reviewText.text=reviewCard[position].reviewText
        binding.petsitterImg.setImageResource(R.drawable.example1)
        binding.whatService.text=reviewCard[position].serviceList
        binding.petsittername.text=reviewCard[position].petsitterName
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
        return reviewCard.size
    }
}