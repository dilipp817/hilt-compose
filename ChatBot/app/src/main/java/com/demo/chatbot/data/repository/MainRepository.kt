package com.demo.chatbot.data.repository

import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import com.demo.chatbot.common.BaseApiResponse
import com.demo.chatbot.common.NetworkResult
import com.demo.chatbot.data.api.ApiService
import com.demo.chatbot.data.model.PhotosModel
import javax.inject.Inject

@ActivityRetainedScoped
class MainRepository @Inject constructor(private val apiService: ApiService, private val defaultDispatcher: CoroutineDispatcher) : BaseApiResponse() {
    suspend fun getPhotos() : NetworkResult<List<PhotosModel>> {
           return withContext(defaultDispatcher){safeApiCall { apiService.getPhotos() }}
    }

}