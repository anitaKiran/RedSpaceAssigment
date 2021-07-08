package com.redspace.rickandmortytest.data.network

import com.redspace.rickandmortytest.data.model.AllEpisodesResponse
import com.redspace.rickandmortytest.data.model.Episode
import com.redspace.rickandmortytest.data.model.RickandMortyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Anita Kiran on 26,June,2021
 */
interface ApiService {

    @GET("character")
    suspend fun getCharacters(): Response<RickandMortyResponse>

    @GET("location")
    suspend fun getLocations(): Response<RickandMortyResponse>

    @GET("episode")
    suspend fun getAllEpisodes(): Response<AllEpisodesResponse>

    @GET("episode/{episodeNumber}")
    suspend fun getEpisodesById(
        @Path("episodeNumber") episodeNumer : String
    ): Response<List<Episode>>

}