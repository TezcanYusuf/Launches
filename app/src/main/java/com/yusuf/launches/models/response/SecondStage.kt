package com.yusuf.launches.models.response


import com.fasterxml.jackson.annotation.JsonProperty

data class SecondStage(
    @JsonProperty("block")
    val block: Int?,
    @JsonProperty("payloads")
    val payloads: List<Payload?>?
)