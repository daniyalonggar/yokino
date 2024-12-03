package com.example.yokino.data.retrofit.api

import com.example.yokino.models.PopularMovies
import retrofit2.Response

class RetrofitRepository {
 suspend fun getMovies():Response<PopularMovies>{
     return  RetrofitInstance.api.getPopullarMovie()
 }

}