package com.talentfront.freya.userreview.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserReviewRequest(
    val revieweeId: Int? = null,
    val review: String? = null,
    val score: Int? = null
)
