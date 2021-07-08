package com.redspace.rickandmortytest.data.network

import com.redspace.rickandmortytest.data.model.AllEpisodesResponse
import com.redspace.rickandmortytest.data.model.Episode
import com.redspace.rickandmortytest.data.model.RickandMortyResponse
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Anita Kiran on 26,June,2021
 */
class ApiServiceImpl @Inject constructor(val apiService: ApiService) {
    suspend fun getCharacters(): Response<RickandMortyResponse> = apiService.getCharacters()

    suspend fun getLocations(): Response<RickandMortyResponse> = apiService.getLocations()

    suspend fun getAllEpisodes(): Response<AllEpisodesResponse> = apiService.getAllEpisodes()

    suspend fun getEpisodesById(episodeNum:String): Response <List<Episode>> = apiService.getEpisodesById(episodeNum)

}