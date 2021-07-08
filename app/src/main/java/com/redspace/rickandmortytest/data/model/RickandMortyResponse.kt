package com.redspace.rickandmortytest.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

/**
 * Created by Anita Kiran on 26,June,2021
 */
@Parcelize
data class RickandMortyResponse(
    @Expose val info: Info,
    @Expose val results: List<Results>
) : Parcelable
