package com.example.pulent.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pulent.R
import com.example.pulent.util.ImageRetriever
import models.Song

class SongListAdapter : RecyclerView.Adapter<SongListAdapter.ViewHolder> {

    protected var list: MutableList<Song>

    constructor(list: MutableList<Song>) {
        this.list = list
    }

    inner class ViewHolder: RecyclerView.ViewHolder {
        var image: ImageView
        var name: TextView
        var album: TextView

        constructor(itemView: View): super(itemView) {
            image = itemView.findViewById(R.id.image)
            name = itemView.findViewById(R.id.name)
            album = itemView.findViewById(R.id.album)

            itemView.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.song_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.name.text = list[i].name
        viewHolder.album.text = list[i].album

        var imageRetriever = ImageRetriever(list[i].image, viewHolder.image)
        imageRetriever.fitImage()

    }

    override fun getItemCount(): Int {
        return list.size
    }
}