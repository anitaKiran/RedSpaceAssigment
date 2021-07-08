package com.redspace.rickandmortytest.data.repository

import com.redspace.rickandmortytest.data.network.ApiServiceImpl
import javax.inject.Inject

/**
 * Created by Anita Kiran on 26,June,2021
 */
class MainRepository @Inject constructor(private val apiServiceImpl: ApiServiceImpl) {

    suspend fun getCharacters() = apiServiceImpl.getCharacters()

    suspend fun getLocations() = apiServiceImpl.getLocations()

    suspend fun getAllEpisodes() = apiServiceImpl.getAllEpisodes()

    suspend fun getEpisodesById(episodeNum:String) = apiServiceImpl.getEpisodesById(episodeNum)
}