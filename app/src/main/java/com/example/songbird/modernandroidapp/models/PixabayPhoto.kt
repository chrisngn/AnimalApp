package com.example.songbird.modernandroidapp.models

import com.google.gson.annotations.SerializedName

data class PixabayPhoto(@SerializedName("previewURL") var previewUrl: String,
                        @SerializedName("webformatURL") var webUrl: String)

data class PixabayResponse(@SerializedName("hits") var photos: List<PixabayPhoto>)