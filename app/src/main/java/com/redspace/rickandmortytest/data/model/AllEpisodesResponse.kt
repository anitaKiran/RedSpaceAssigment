package com.redspace.rickandmortytest.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

/**
 * Created by Anita Kiran on 06,July,2021
 */
@Parcelize
data class AllEpisodesResponse(
    @Expose val info: Info,
    @Expose val results: List<Episode>
) : Parcelable