package eu.vonamor.learning.network

import com.squareup.moshi.Json


data class Status(
    val id: String,
    @Json(name = "status") val status: String
)