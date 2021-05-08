package com.talentfront.freya.company.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class CompanyRequest(
    val companyName: String,
    val mission: String? = null,
    val product: String? = null,
    val numberEmployees: Int? = null,
    val locations: List<String>? = null
)
