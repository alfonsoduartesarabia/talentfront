package com.talentfront.freya.user.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserSkillsRequest(
    val add: List<String>? = null,
    val remove: List<String>? = null
)
