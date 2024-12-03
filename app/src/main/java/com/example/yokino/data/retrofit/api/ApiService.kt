package com.example.yokino.data.retrofit.api

import com.example.yokino.models.PopularMovies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("X-API-KEY: 473e1748-9874-4151-bc69-4b3644ebb470")
    @GET("/api/v2.2/films/collections?type=TOP_POPULAR_MOVIES")
    suspend fun getPopullarMovie():Response<PopularMovies>
}