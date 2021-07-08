package com.redspace.rickandmortytest.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by Anita Kiran on 26,June,2021
 */
@Parcelize
data class Results(
    @Expose val id: Int,
    @Expose val name: String,
    @Expose val status: String,
    @Expose val species: String,
    @Expose val type: String?,
    @Expose val gender: String,
    @Expose val origin: Origin,
    @Expose val location: Location,
    @Expose val dimension: String?,
    @Expose val image: String,
    @Expose val air_date:String?,
    @Expose val episodeName:String?,
    @Expose val episode : List<String>,
    @Expose val residents: List<String>?,
    @Expose val url: String,
    @Expose val created: String
) : Parcelable
