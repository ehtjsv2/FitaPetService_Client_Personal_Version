package com.example.fitapet.PetsitterList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

data class PetsitterListModel (
    val petsitterName : String,
    val career : String,
    val havepet : String,
    val gender : String,
    val age : String,
    val imageUrl : String
)

//class PetsitterAdapter : ListAdapter<PetsitterListModel, PetsitterAdapter.ViewHolder>(diffUtil){
//    inner class ViewHolder (private val binding: ItemArticleBinding): RecyclerView.ViewHolder(binding.root){
//        fun bind(articleModel: PetsitterListModel){
//            binding.titleTextView.text = articleModel.title
//            binding.titleTextView.text = articleModel.title
//            binding.priceTextView.text = articleModel.price
//            if(PetsitterListModel.imageUrl.isNotEmpty()){
//                Glide.with(binding.thumbnailImageView)
//                    .load(articleModel.imageUrl)
//                    .into(binding.thumbnailImageView)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(ItemArticleBinding.inflate(LayoutInflater.from(parent.context),parent,false))
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(currentList[position])
//    }
//
//    companion object{
//        val diffUtil = object  : DiffUtil.ItemCallback<PetsitterListModel>(){
//            override fun areItemsTheSame(oldItem: PetsitterListModel, newItem: PetsitterListModel): Boolean {
//                return oldItem.createdAt == newItem.createdAt
//            }
//
//            override fun areContentsTheSame(oldItem: PetsitterListModel, newItem: PetsitterListModel): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//}