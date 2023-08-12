package com.yusuf.launches.models.response


import com.fasterxml.jackson.annotation.JsonProperty

data class Reuse(
    @JsonProperty("capsule")
    val capsule: Boolean?,
    @JsonProperty("core")
    val core: Boolean?,
    @JsonProperty("fairings")
    val fairings: Boolean?,
    @JsonProperty("side_core1")
    val sideCore1: Boolean?,
    @JsonProperty("side_core2")
    val sideCore2: Boolean?
)