package com.example.songbird.modernandroidapp.models

import com.google.gson.annotations.SerializedName

data class Photo(var id: String,
                 var owner: String,
                 var title: String,
                 @SerializedName("url_s") var previewUrl: String)

data class PhotoList(@SerializedName("photo") var photos: List<Photo>)

data class FlickrResponse(@SerializedName("photos") var photoList: PhotoList)
