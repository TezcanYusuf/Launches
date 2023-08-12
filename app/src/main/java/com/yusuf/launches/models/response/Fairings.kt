package com.yusuf.launches.models.response


import com.fasterxml.jackson.annotation.JsonProperty

data class Fairings(
    @JsonProperty("recovered")
    val recovered: Boolean?,
    @JsonProperty("recovery_attempt")
    val recoveryAttempt: Boolean?,
    @JsonProperty("reused")
    val reused: Boolean?,
    @JsonProperty("ship")
    val ship: String?
)