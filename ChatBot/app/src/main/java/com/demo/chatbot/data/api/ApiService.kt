package com.demo.chatbot.data.api

import com.demo.chatbot.data.model.PhotosModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/photos")
    suspend fun getPhotos(): Response<List<PhotosModel>>

}
