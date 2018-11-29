package com.example.songbird.modernandroidapp.models

import com.google.gson.annotations.SerializedName

data class CatFact(@SerializedName("_id") var id: String,
                   var text: String)

data class CatFactResponse(@SerializedName("all") var facts: List<CatFact>)