package com.yusuf.launches.models.response


import com.fasterxml.jackson.annotation.JsonProperty

data class Core(
    @JsonProperty("block")
    val block: Int?,
    @JsonProperty("core_serial")
    val coreSerial: String?,
    @JsonProperty("flight")
    val flight: Int?,
    @JsonProperty("gridfins")
    val gridfins: Boolean?,
    @JsonProperty("land_success")
    val landSuccess: Boolean?,
    @JsonProperty("landing_intent")
    val landingIntent: Boolean?,
    @JsonProperty("landing_type")
    val landingType: String?,
    @JsonProperty("landing_vehicle")
    val landingVehicle: String?,
    @JsonProperty("legs")
    val legs: Boolean?,
    @JsonProperty("reused")
    val reused: Boolean?
)