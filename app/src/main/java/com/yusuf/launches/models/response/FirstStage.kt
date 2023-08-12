package com.yusuf.launches.models.response


import com.fasterxml.jackson.annotation.JsonProperty

data class FirstStage(
    @JsonProperty("cores")
    val cores: List<Core?>?
)