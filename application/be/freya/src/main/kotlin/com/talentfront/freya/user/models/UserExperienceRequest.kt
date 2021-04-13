package com.talentfront.freya.user.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDate

@JsonIgnoreProperties(ignoreUnknown = true)
data class UserExperienceRequest(
    val title: String? = null,
    val company: String? = null,
    val description: String? = null,
    val dateStart: LocalDate? = null,
    val dateEnd: LocalDate? = null
)
