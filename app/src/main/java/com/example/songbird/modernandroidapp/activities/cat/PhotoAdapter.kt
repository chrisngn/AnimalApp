package com.example.songbird.modernandroidapp.activities.cat

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.songbird.modernandroidapp.models.PixabayPhoto
import com.example.songbird.modernandroidapp.R

class PhotoAdapter(var photos: List<PixabayPhoto>) : RecyclerView.Adapter<PhotoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.rv_item_photo, parent, false)
        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(viewHolder: PhotoViewHolder, position: Int) {
        viewHolder.bind(photos[position])
    }
}

class PhotoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    private val imageView: ImageView = itemView as ImageView

    fun bind(photo : PixabayPhoto) {
        Glide.with(imageView.context)
            .load(photo.previewUrl)
            .into(imageView)
    }
}