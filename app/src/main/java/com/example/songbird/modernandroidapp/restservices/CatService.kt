package com.example.songbird.modernandroidapp.restservices

import com.example.songbird.modernandroidapp.models.CatFactResponse
import com.example.songbird.modernandroidapp.models.PixabayResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CatService {

//    @GET("v1/images/search?limit=10&mime_types=png")
//    fun getImages(): Call<List<Photo>>

//    @GET("?api_key=841a14fda0317b20a690e5f80c9b6022" +
//            "&method=flickr.photos.search" +
//            "&format=json" +
//            "&nojsoncallback=1" +
//            "&extras=url_s")
//    fun getImages(@Query("text") query: String): Call<FlickrResponse>

    @GET("api?key=9039512-dec434f0a88ad706feb85ae64" +
            "&q=animal" +
            "&image_type=photo")
    fun getImages(@Query("q") query: String) : Call<PixabayResponse>

    @GET("//cat-fact.herokuapp.com/facts")
    fun getFacts() : Call<CatFactResponse>
}
