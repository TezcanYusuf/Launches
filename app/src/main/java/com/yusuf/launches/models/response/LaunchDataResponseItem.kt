package com.yusuf.launches.models.response


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class LaunchDataResponseItem(
    @JsonProperty("details")
    val details: String?,
    @JsonProperty("launch_success")
    val launchSuccess: Boolean?,
    @JsonProperty("launch_year")
    val launchYear: String?,
    @JsonProperty("links")
    val links: Links?,
    @JsonProperty("mission_name")
    val missionName: String = "",
    @JsonProperty("rocket")
    val rocket: Rocket?,
)