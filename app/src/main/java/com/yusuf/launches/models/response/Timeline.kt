package com.yusuf.launches.models.response


import com.fasterxml.jackson.annotation.JsonProperty

data class Timeline(
    @JsonProperty("beco")
    val beco: Int?,
    @JsonProperty("center_core_boostback")
    val centerCoreBoostback: Int?,
    @JsonProperty("center_core_entry_burn")
    val centerCoreEntryBurn: Int?,
    @JsonProperty("center_core_landing")
    val centerCoreLanding: Int?,
    @JsonProperty("center_stage_sep")
    val centerStageSep: Int?,
    @JsonProperty("dragon_bay_door_deploy")
    val dragonBayDoorDeploy: Int?,
    @JsonProperty("dragon_separation")
    val dragonSeparation: Int?,
    @JsonProperty("dragon_solar_deploy")
    val dragonSolarDeploy: Int?,
    @JsonProperty("engine_chill")
    val engineChill: Int?,
    @JsonProperty("fairing_deploy")
    val fairingDeploy: Int?,
    @JsonProperty("first_stage_boostback_burn")
    val firstStageBoostbackBurn: Int?,
    @JsonProperty("first_stage_entry_burn")
    val firstStageEntryBurn: Int?,
    @JsonProperty("first_stage_landing")
    val firstStageLanding: Int?,
    @JsonProperty("first_stage_landing_burn")
    val firstStageLandingBurn: Int?,
    @JsonProperty("go_for_launch")
    val goForLaunch: Int?,
    @JsonProperty("go_for_prop_loading")
    val goForPropLoading: Int?,
    @JsonProperty("ignition")
    val ignition: Int?,
    @JsonProperty("liftoff")
    val liftoff: Int?,
    @JsonProperty("maxq")
    val maxq: Int?,
    @JsonProperty("meco")
    val meco: Int?,
    @JsonProperty("payload_deploy")
    val payloadDeploy: Int?,
    @JsonProperty("payload_deploy_1")
    val payloadDeploy1: Int?,
    @JsonProperty("payload_deploy_2")
    val payloadDeploy2: Int?,
    @JsonProperty("prelaunch_checks")
    val prelaunchChecks: Int?,
    @JsonProperty("propellant_pressurization")
    val propellantPressurization: Int?,
    @JsonProperty("rp1_loading")
    val rp1Loading: Int?,
    @JsonProperty("seco-1")
    val seco1: Int?,
    @JsonProperty("seco-2")
    val seco2: Int?,
    @JsonProperty("seco-3")
    val seco3: Int?,
    @JsonProperty("seco-4")
    val seco4: Int?,
    @JsonProperty("second_stage_ignition")
    val secondStageIgnition: Int?,
    @JsonProperty("second_stage_restart")
    val secondStageRestart: Int?,
    @JsonProperty("side_core_boostback")
    val sideCoreBoostback: Int?,
    @JsonProperty("side_core_entry_burn")
    val sideCoreEntryBurn: Int?,
    @JsonProperty("side_core_landing")
    val sideCoreLanding: Int?,
    @JsonProperty("side_core_sep")
    val sideCoreSep: Int?,
    @JsonProperty("stage1_lox_loading")
    val stage1LoxLoading: Int?,
    @JsonProperty("stage1_rp1_loading")
    val stage1Rp1Loading: Int?,
    @JsonProperty("stage2_lox_loading")
    val stage2LoxLoading: Int?,
    @JsonProperty("stage2_rp1_loading")
    val stage2Rp1Loading: Int?,
    @JsonProperty("stage_sep")
    val stageSep: Int?,
    @JsonProperty("webcast_launch")
    val webcastLaunch: Int?,
    @JsonProperty("webcast_liftoff")
    val webcastLiftoff: Int?
)