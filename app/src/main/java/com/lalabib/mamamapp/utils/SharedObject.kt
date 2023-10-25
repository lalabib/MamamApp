package com.lalabib.mamamapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lalabib.mamamapp.R

object SharedObject {

    const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    const val DEFAULT_VALUE = "Beef"

    fun loadAvatar(imageView: ImageView, avatar: String?) {
        Glide.with(imageView.context)
            .load(avatar)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_broken_img)
            )
            .into(imageView)
    }

    fun extractYouTubeVideoId(youtubeUrl: String): String? {
        val queryParameters = youtubeUrl.split("?").getOrNull(1)
        val params = queryParameters?.split("&")
        params?.forEach {
            val keyValue = it.split("=")
            if (keyValue.size == 2 && keyValue[0] == "v") {
                return keyValue[1]
            }
        }
        return null
    }
}