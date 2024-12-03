package com.example.yokino.screens.main

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yokino.MAIN
import com.example.yokino.data.retrofit.api.RetrofitRepository
import com.example.yokino.models.MoviesModel
import com.example.yokino.models.PopularMovies
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel: ViewModel() {
    private val repository = RetrofitRepository()
    val myMovies: MutableLiveData<Response<PopularMovies>> = MutableLiveData()

    fun getMovies(){
        viewModelScope.launch {
            try {
                myMovies.value = repository.getMovies()
            }catch (e:Exception){
                Log.e("ERROR", e.message.toString())
            }

        }
    }
}