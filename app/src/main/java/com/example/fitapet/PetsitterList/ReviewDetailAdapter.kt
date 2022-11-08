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
import com.example.fitapet.PetsitterList.ReviewDetailCard
import com.example.fitapet.R
import com.example.fitapet.databinding.PetItemMainBinding
import com.example.fitapet.databinding.FragmentFriendBinding
import com.example.fitapet.databinding.FriendListBinding
import com.example.fitapet.databinding.ReviewDetailBinding
import com.example.fitapet.databinding.ReviewHomeBinding
import com.example.fitapet.PetsitterList.ReviewPageFragment
import com.example.fitapet.navfragment.FriendFragment

class ReviewDetailAdapter(val reviewdetailcard:MutableList<ReviewDetailCard>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    class MyViewHolder(val binding: ReviewDetailBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ReviewDetailAdapter.MyViewHolder(
            ReviewDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("LOGTest",""+itemCount+"---"+position)
        val binding = (holder as ReviewDetailAdapter.MyViewHolder).binding
        binding.parentImage.setImageResource(R.drawable.example1)
        binding.parentName.text=reviewdetailcard[position].parentName
        binding.reviewImage.setImageResource(R.drawable.example1)
        binding.reviewText.text=reviewdetailcard[position].reviewText
        binding.petsitterImg.setImageResource(R.drawable.example1)
        binding.whatService.text=reviewdetailcard[position].serviceList
        binding.petsittername.text=reviewdetailcard[position].petsitterName
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
        return reviewdetailcard.size
    }
}