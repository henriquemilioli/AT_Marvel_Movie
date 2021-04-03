package com.example.at_marvel_movie.api

import com.example.at_marvel_movie.api.service.SeriesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var instance: Retrofit? = null
    private fun getRetrofit(): Retrofit {
        if(instance == null)
            instance = Retrofit
                .Builder()
                .baseUrl("http://gateway.marvel.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return instance as Retrofit
    }

    fun getSeriesService(): SeriesService
        = getRetrofit().create(SeriesService::class.java)
}