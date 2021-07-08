package com.redspace.rickandmortytest.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

/**
 * Created by Anita Kiran on 26,June,2021
 */
@Parcelize
data class Info(
    @Expose val count: Int,
    @Expose val pages: Int,
    @Expose val next: String?,
    @Expose val prev: String?
) : Parcelable
