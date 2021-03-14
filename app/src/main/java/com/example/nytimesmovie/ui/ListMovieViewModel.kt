package com.example.nytimesmovie.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.nytimesmovie.data.model.Model
import com.example.nytimesmovie.data.model.ResultData
import com.example.nytimesmovie.domain.usecase.movieusecase.MovieGetUseCase
import com.example.nytimesmovie.domain.usecase.movieusecase.MovieRefreshUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ListMovieViewModel @ViewModelInject constructor
    (
    private var movieRefreshUseCase: MovieRefreshUseCase,
    private var movieGetUseCase: MovieGetUseCase
) : ViewModel() {

    private val _movies: MutableLiveData<List<Model.Movie>> = MutableLiveData()
    val movies: LiveData<List<Model.Movie>> = _movies

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    private val _failure: MutableLiveData<String> = MutableLiveData()
    val failure: LiveData<String> = _failure

    private var _error: MutableLiveData<Throwable> = MutableLiveData()
    val error: LiveData<Throwable> = _error


    init {
        refresh()
        viewModelScope.launch {
            movieGetUseCase.execute(Unit).collect {
                _movies.value = it
            }

        }

    }

    private fun refresh() {
        _loading.postValue(false)
        viewModelScope.launch {
            val resourceData = movieRefreshUseCase.execute(Unit)
            when (resourceData) {
                is ResultData.Success -> {
                    _loading.postValue(false)
                    _movies.value = resourceData.value

                }
                is ResultData.Failure -> {
                    _loading.postValue(false)
                    _failure.postValue(resourceData.message)
                }
                is ResultData.Error -> {
                    _loading.postValue(false)
                    _error.postValue(resourceData.throwable)
                }
                else -> {
                }
            }
        }
    }
}