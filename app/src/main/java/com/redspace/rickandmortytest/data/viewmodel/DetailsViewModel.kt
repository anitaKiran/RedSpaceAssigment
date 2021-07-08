package com.redspace.rickandmortytest.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redspace.rickandmortytest.data.model.Episode
import com.redspace.rickandmortytest.data.repository.MainRepository
import com.redspace.rickandmortytest.util.NetworkHelper
import com.redspace.rickandmortytest.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Anita Kiran on 30,June,2021
 */
@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _episodesResponse = MutableLiveData<Resource<List<Episode>>>()
    val episodeData: LiveData<Resource<List<Episode>>> = _episodesResponse

    fun getEpisodesById(episodeNum: String) {
        viewModelScope.launch() {
            _episodesResponse.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getEpisodesById(episodeNum)?.let {
                    if (it.isSuccessful) {
                        _episodesResponse.postValue(Resource.success(it.body()))
                    } else {
                        _episodesResponse.postValue(Resource.error(it.errorBody().toString(), null))
                    }
                }
            } else
                _episodesResponse.postValue(Resource.error("Failed to load data", null))
        }
    }
}