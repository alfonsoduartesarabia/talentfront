package com.talentfront.freya.user.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserProfileRequest(
    val userId: Int
)
