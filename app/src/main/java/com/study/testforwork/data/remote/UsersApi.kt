package com.study.testforwork.data.remote

import com.study.testforwork.data.remote.response.ResponseDto
import retrofit2.http.GET

interface UsersApi {

    @GET("/api/")
    suspend fun fetchUsersFromApi() : ResponseDto

}