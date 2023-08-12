package com.yusuf.launches.models.response


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Rocket(
    @JsonProperty("rocket_name")
    val rocketName: String? = "",
)