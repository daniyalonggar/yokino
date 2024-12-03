package com.example.yokino.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yokino.MAIN
import com.example.yokino.R
import com.example.yokino.models.Item
import com.example.yokino.models.MoviesModel
import com.example.yokino.models.PopularMovies

class MainAdapter: RecyclerView.Adapter<MainAdapter.MyViewHolder>()
{

private var listMovies = emptyList<Item>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle: TextView = view.findViewById(R.id.item_title)
        val itemDate: TextView = view.findViewById(R.id.item_date)
        val itemImg: ImageView = view.findViewById(R.id.item_img)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainAdapter.MyViewHolder, position: Int) {
        holder.itemTitle.text = listMovies[position].nameRu
        holder.itemDate.text = listMovies[position].year

        Glide.with(holder.itemView.context)
            .load(listMovies[position].posterUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemImg)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    fun setList(list: List<Item>){
        listMovies = list
        notifyDataSetChanged()
    }

}
