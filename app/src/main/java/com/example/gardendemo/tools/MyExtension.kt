package com.example.gardendemo.tools

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.*
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions


open class MyExtension()

fun debug(text: Any) {
    text?.let {
        Log.w("JohnOut", text.toString())
    }
}

fun Context?.toast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT) = this?.let { Toast.makeText(it, text, duration).show() }

fun Context?.toast(text: Int, duration: Int = Toast.LENGTH_SHORT) = this?.let { Toast.makeText(it, text, duration).show() }

val CIRCLE_CROP = 1
val ROUND_CORNER = 2
fun ImageView.loadUrl(url: String, cropType: Int? = 0, progress: ProgressBar? = null, isClearCache: Boolean? = false) {
    loadImage(url, cropType, progress, isClearCache)
}

private fun ImageView.loadImage(url: String, cropType: Int? = 0, progress: ProgressBar? = null, clearCache: Boolean? = false) {

    var targetImageView = this
    var requestOptions = RequestOptions()
    when (cropType) {
        CIRCLE_CROP -> {
            requestOptions = requestOptions.transforms(CenterCrop(), CircleCrop())
        }
        ROUND_CORNER -> {
            requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(20))
        }
    }

    if (clearCache == true) {
        requestOptions = requestOptions.diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
    }

    Glide.with(context)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade(600))
            .apply(requestOptions)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(e: GlideException?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    progress?.let { progress.visibility = View.GONE }
                    return false
                }

                override fun onResourceReady(resource: Drawable?, model: Any?, target: com.bumptech.glide.request.target.Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    progress?.let { progress.visibility = View.GONE }
                    targetImageView.setImageDrawable(resource)
                    return false
                }
            })
            .into(this)
}