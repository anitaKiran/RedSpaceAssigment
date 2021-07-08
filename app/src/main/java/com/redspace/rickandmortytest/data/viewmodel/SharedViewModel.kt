package com.redspace.rickandmortytest.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redspace.rickandmortytest.data.model.AllEpisodesResponse
import com.redspace.rickandmortytest.data.model.RickandMortyResponse
import com.redspace.rickandmortytest.data.repository.MainRepository
import com.redspace.rickandmortytest.util.NetworkHelper
import com.redspace.rickandmortytest.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Anita Kiran on 05,July,2021
 */
@HiltViewModel
class SharedViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _characterResponse = MutableLiveData<Resource<RickandMortyResponse>>()
    val charactersData: LiveData<Resource<RickandMortyResponse>> = _characterResponse

    private val _locationResponse = MutableLiveData<Resource<RickandMortyResponse>>()
    val locationData: LiveData<Resource<RickandMortyResponse>> = _locationResponse

    private val _episodesResponse = MutableLiveData<Resource<AllEpisodesResponse>>()
    val episodesData: LiveData<Resource<AllEpisodesResponse>> = _episodesResponse

    fun getAllCharacters() {
        viewModelScope.launch() {
            _characterResponse.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getCharacters()?.let {
                    if (it.isSuccessful) {
                        _characterResponse.postValue(Resource.success(it.body()))
                    } else {
                        _characterResponse.postValue(
                            Resource.error(it.errorBody().toString(), null))
                    }
                }
            } else {
                _characterResponse.postValue(Resource.error("Failed to load data", null))
            }
        }
    }

    fun getLocations() {
        viewModelScope.launch() {
            _locationResponse.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getLocations()?.let {
                    if (it.isSuccessful) {
                        _locationResponse.postValue(Resource.success(it.body()))
                    } else {
                        _locationResponse.postValue(Resource.error(it.errorBody().toString(), null))
                    }
                }
            } else {
                _locationResponse.postValue(Resource.error("Failed to load data", null))
            }
        }
    }

    fun getAllEpisodes() {
        viewModelScope.launch() {
            _episodesResponse.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getAllEpisodes()?.let {
                    if (it.isSuccessful) {
                        _episodesResponse.postValue(Resource.success(it.body()))
                    } else {
                        _episodesResponse.postValue(Resource.error("Failed to load data", null))
                    }
                }
            } else {
                _locationResponse.postValue(Resource.error("Failed to load data", null))
            }
        }
    }
}