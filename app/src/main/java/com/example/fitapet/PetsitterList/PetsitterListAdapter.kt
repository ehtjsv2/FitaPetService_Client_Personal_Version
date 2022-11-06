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
        binding.petsitterImage.setImageResource(R.drawable.ic_launcher_foreground)
        binding.petsitterImage.setBackgroundResource(R.drawable.ic_launcher_background)
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
//    fun bind(position: Int) {
//        ivProfile.setImageResource(items[position].imageRes)
//        ivProfile.setBackgroundResource(items[position].backgroundRes)
//        tvName.text = items[position].name
//        tvcareer.text = items[position].career
//        tvhavepet.text = items[position].havepet
//        tvgender.text = items[position].gender
//        tvage.text = items[position].age
//        tvpetsittertext.text = items[position].petsitterText
//    }
//inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//    var ivProfile: ImageView = itemView.findViewById(R.id.petsitterImage)
//    var tvName: TextView = itemView.findViewById(R.id.petsitterName)
//    var tvcareer: TextView = itemView.findViewById(R.id.petsitterCareer)
//    var tvhavepet: TextView = itemView.findViewById(R.id.petsitterHavePet)
//    var tvgender: TextView = itemView.findViewById(R.id.petsitterGender)
//    var tvage: TextView = itemView.findViewById(R.id.petsitterAge)
//    var tvpetsittertext: TextView = itemView.findViewById(R.id.PetsitterText)
//
//

//}
//
//override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//    val context = parent.context
//    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//    val view: View = inflater.inflate(R.layout.dog_service_list, parent, false)
//
//    return MyViewHolder(view)
//}
//
//override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//    holder.bind(position)
//}
//
//override fun getItemCount(): Int = items.size

//    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
////        public var itemimage: ImageView = itemview.petsitterImage
////        public var itemtitle: TextView = itemview.item_title
////        public var itemdetail: TextView = itemview.item_detail
//    }

//    override fun onCreateViewHolder(viewgroup: ViewGroup, position: Int): MyViewHolder {
//        var v: View = LayoutInflater.from(viewgroup.context).inflate(R.layout.dog_service_list, viewgroup, false)
//
//        return MyViewHolder(v)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
////        holder.itemtitle.setText(titles.get(position))
////        holder.itemimage.setImageResource(images.get(position))
////        holder.itemdetail.setText(details.get(position))
//    }
//
//    override fun getItemCount(): Int {
//        return titles.size
//    }

//var items = items
//
