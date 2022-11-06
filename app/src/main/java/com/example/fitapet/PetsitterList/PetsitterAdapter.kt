package com.example.fitapet.PetsitterList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitapet.R

class PetsitterAdapter(): RecyclerView.Adapter<PetsitterAdapter.MyViewHolder>(){

    var titles = arrayOf("one", "two", "three", "four", "five")
    var details = arrayOf("Item one", "Item two", "Item three", "Item four", "Itme five")

    var images = intArrayOf(
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground)


    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
//        public var itemimage: ImageView = itemview.item_image
//        public var itemtitle: TextView = itemview.item_title
//        public var itemdetail: TextView = itemview.item_detail
    }

    override fun onCreateViewHolder(viewgroup: ViewGroup, position: Int): MyViewHolder {
        var v: View = LayoutInflater.from(viewgroup.context).inflate(R.layout.dog_service_list, viewgroup, false)

        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.itemtitle.setText(titles.get(position))
//        holder.itemimage.setImageResource(images.get(position))
//        holder.itemdetail.setText(details.get(position))
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}