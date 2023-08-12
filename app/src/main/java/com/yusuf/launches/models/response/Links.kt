package com.yusuf.launches.models.response


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Links(
    @JsonProperty("mission_patch")
    val missionPatch: String? = "",
    @JsonProperty("youtube_id")
    val youtubeId: String? = "",
)