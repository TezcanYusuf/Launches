package com.yusuf.launches.models.response


import com.fasterxml.jackson.annotation.JsonProperty

data class OrbitParams(
    @JsonProperty("apoapsis_km")
    val apoapsisKm: Double?,
    @JsonProperty("arg_of_pericenter")
    val argOfPericenter: Double?,
    @JsonProperty("eccentricity")
    val eccentricity: Double?,
    @JsonProperty("epoch")
    val epoch: String?,
    @JsonProperty("inclination_deg")
    val inclinationDeg: Double?,
    @JsonProperty("lifespan_years")
    val lifespanYears: Double?,
    @JsonProperty("longitude")
    val longitude: Double?,
    @JsonProperty("mean_anomaly")
    val meanAnomaly: Double?,
    @JsonProperty("mean_motion")
    val meanMotion: Double?,
    @JsonProperty("periapsis_km")
    val periapsisKm: Double?,
    @JsonProperty("period_min")
    val periodMin: Double?,
    @JsonProperty("raan")
    val raan: Double?,
    @JsonProperty("reference_system")
    val referenceSystem: String?,
    @JsonProperty("regime")
    val regime: String?,
    @JsonProperty("semi_major_axis_km")
    val semiMajorAxisKm: Double?
)