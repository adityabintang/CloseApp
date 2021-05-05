package com.bintang.tripapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bintang.tripapp.R
import com.bintang.tripapp.main.DetailActivity
import com.bintang.tripapp.model.Berita
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_activity.view.*

class BeritaAdapter(val articels: List<Berita>): RecyclerView.Adapter<BeritaAdapter.BeritaHolder>() {
    class BeritaHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(get: Berita) {
            val img = itemView.findViewById<ImageView>(R.id.image)
            val text = itemView.findViewById<TextView>(R.id.text)

            text.text = get.title
            Glide.with(itemView.context)
                .load(get.urlToImage)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_activity,parent, false)

        val holder = BeritaHolder(view)

        return holder
    }

    override fun onBindViewHolder(holder: BeritaHolder, position: Int) {
        holder.bind(articels.get(position))

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("judul", articels.get(position).title)
            intent.putExtra("deskripsi", articels.get(position).description)
            intent.putExtra("gambar", articels.get(position).urlToImage)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return articels.size
    }
}