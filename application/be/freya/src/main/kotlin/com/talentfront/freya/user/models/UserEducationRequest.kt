package com.talentfront.freya.user.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserEducationRequest(
    val school: String? = null,
    val remove: List<String>? = null
)
