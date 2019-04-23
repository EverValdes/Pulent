package com.example.pulent.util

import android.widget.ImageView
import com.example.pulent.R
import com.squareup.picasso.Picasso


class ImageRetriever(private var urlImage: String, private var imageView: ImageView) {

    fun fitImage() {
        Picasso.get().load(urlImage).fit().error(R.drawable.no_image_available).into(imageView)

    }

    fun addImage() {
        Picasso.get().load(urlImage).error(R.drawable.no_image_available).into(imageView)

    }
}
