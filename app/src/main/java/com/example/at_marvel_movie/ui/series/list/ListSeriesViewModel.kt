package com.example.at_marvel_movie.ui.series.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.at_marvel_movie.api.ApiClient
import com.example.at_marvel_movie.model.Series
import kotlinx.coroutines.launch
import java.lang.Exception

class ListSeriesViewModel : ViewModel() {

    private val _series = MutableLiveData<List<Series>>()
    val series: LiveData<List<Series>> = _series

    init {
        viewModelScope.launch {
            try {
                val response =
                    ApiClient
                        .getSeriesService().all(20, 100)
                val data = response.data
                if
                        (data!= null)
                    _series.value = data!!.results!!
            }catch (e: Exception){
                Log.i("LCVWResponde",
                    "${e.message}")

            }

        }
    }
}