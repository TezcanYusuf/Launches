package com.yusuf.launches.models.response


import com.fasterxml.jackson.annotation.JsonProperty

data class Payload(
    @JsonProperty("cap_serial")
    val capSerial: String?,
    @JsonProperty("cargo_manifest")
    val cargoManifest: String?,
    @JsonProperty("customers")
    val customers: List<String?>?,
    @JsonProperty("flight_time_sec")
    val flightTimeSec: Int?,
    @JsonProperty("manufacturer")
    val manufacturer: String?,
    @JsonProperty("mass_returned_kg")
    val massReturnedKg: Double?,
    @JsonProperty("mass_returned_lbs")
    val massReturnedLbs: Double?,
    @JsonProperty("nationality")
    val nationality: String?,
    @JsonProperty("norad_id")
    val noradId: List<Int?>?,
    @JsonProperty("orbit")
    val orbit: String?,
    @JsonProperty("orbit_params")
    val orbitParams: OrbitParams?,
    @JsonProperty("payload_id")
    val payloadId: String?,
    @JsonProperty("payload_mass_kg")
    val payloadMassKg: Double?,
    @JsonProperty("payload_mass_lbs")
    val payloadMassLbs: Double?,
    @JsonProperty("payload_type")
    val payloadType: String?,
    @JsonProperty("reused")
    val reused: Boolean?,
    @JsonProperty("uid")
    val uid: String?
)