package com.redspace.rickandmortytest.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

/**
 * Created by Anita Kiran on 02,July,2021
 */
@Parcelize
data class Episode(
    @Expose val id: Int,
    @Expose val name: String,
    @Expose val air_date: String,
    @Expose val episode: String,
    @Expose val characters: List<String>,
) : Parcelable