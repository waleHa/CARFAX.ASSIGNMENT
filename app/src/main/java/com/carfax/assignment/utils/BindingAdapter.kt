package com.carfax.assignment.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageSetter")
fun ImageView.imageSetter(url: String?) {
    if(url != null) {
        Glide.with(this).load(url).centerCrop().into(this)
    }
}
