package com.example.bottomnavigationwithmeow

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MountainAdapter(private val mountainList: ArrayList<Mountain>) : RecyclerView.Adapter<MountainAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_list,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mountainImage.setImageResource(mountainList[position].Image)
        holder.mountainTitle.text = mountainList[position].Title
//        holder.cardView.setOnClickListener {
//            Toast.makeText(getActivity, mountainList[position].Title, Toast.LENGTH_SHORT).show()
//        }

    }

    override fun getItemCount(): Int {
        return mountainList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val mountainImage : ImageView = itemView.findViewById(R.id.iv_img)
        val mountainTitle : TextView = itemView.findViewById(R.id.tv_title)
        val cardView : CardView = itemView.findViewById(R.id.card_view)

    }
}