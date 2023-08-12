package com.yusuf.launches.models.response


import com.fasterxml.jackson.annotation.JsonProperty

data class LaunchFailureDetails(
    @JsonProperty("altitude")
    val altitude: Int?,
    @JsonProperty("reason")
    val reason: String?,
    @JsonProperty("time")
    val time: Int?
)