package com.talentfront.freya.user.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserEducationRequest(
    val school: String? = null,
    val degree: String? = null,
    val major: String? = null,
    val isFinished: Boolean? = null
)
