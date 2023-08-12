package com.yusuf.launches.models.response


import com.fasterxml.jackson.annotation.JsonProperty

data class LaunchSite(
    @JsonProperty("site_id")
    val siteId: String?,
    @JsonProperty("site_name")
    val siteName: String?,
    @JsonProperty("site_name_long")
    val siteNameLong: String?
)