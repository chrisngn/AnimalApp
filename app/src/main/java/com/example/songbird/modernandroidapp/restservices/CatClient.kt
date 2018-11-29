package com.example.songbird.modernandroidapp.restservices

import retrofit2.Retrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory


class CatClient {

    companion object {
//        private const val BASE_URL = "https://api.thecatapi.com/"
//        private const val BASE_URL = "https://api.flickr.com/services/rest/"
        private const val BASE_URL = "https://pixabay.com"
        private var catClient: CatClient? = null

        fun instance() : CatService {
            if (catClient == null) {
                catClient = CatClient()
            }
            return catClient!!.catService!!
        }
    }

    private var catService: CatService? = null

    constructor() {
        setupCatClient()
    }

    private fun setupCatClient() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        catService = retrofit.create<CatService>(CatService::class.java)
    }
}