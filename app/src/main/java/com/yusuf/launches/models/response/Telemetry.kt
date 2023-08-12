package com.yusuf.launches.models.response


import com.fasterxml.jackson.annotation.JsonProperty

data class Telemetry(
    @JsonProperty("flight_club")
    val flightClub: String?
)