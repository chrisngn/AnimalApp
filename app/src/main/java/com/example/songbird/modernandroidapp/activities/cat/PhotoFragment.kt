package com.example.songbird.modernandroidapp.activities.cat


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.songbird.modernandroidapp.*
import com.example.songbird.modernandroidapp.models.PixabayPhoto
import com.example.songbird.modernandroidapp.models.PixabayResponse
import com.example.songbird.modernandroidapp.restservices.CatClient
import kotlinx.android.synthetic.main.fragment_photo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoFragment : Fragment() {

    companion object {
        const val CAT = "cat"
        fun newInstance(): PhotoFragment = PhotoFragment()
    }

    val adapter: PhotoAdapter = PhotoAdapter(listOf<PixabayPhoto>())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        loadPhotos()
    }

    private fun loadPhotos() {
        CatClient.instance().getImages(CAT).enqueue(object : Callback<PixabayResponse> {
            override fun onFailure(call: Call<PixabayResponse>, t: Throwable) {
                println("Pixabay: 🦄: " + t.message)
            }

            override fun onResponse(call: Call<PixabayResponse>, response: Response<PixabayResponse>) {
                if (response.isSuccessful) {
                    println("Pixabay: 🦄: " + response.body()?.photos?.size)
                    val photos = response.body()?.photos
                    photos?.let { updateAdapter(photos) }
                }
            }
        })
    }

    private fun updateAdapter(photos: List<PixabayPhoto>) {
        adapter.photos = photos
        adapter.notifyDataSetChanged()
    }

    private fun setupUI() {
        photoRV.layoutManager = LinearLayoutManager(context)
        photoRV.adapter = adapter
    }
}
