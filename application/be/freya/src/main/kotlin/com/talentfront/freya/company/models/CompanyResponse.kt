package com.talentfront.freya.company.models

data class CompanyResponse(
    val companyId: Int,
    val companyName: String,
    val mission: String,
    val product: String,
    val numberEmployees: Int,
    val locations: Array<String>,
)
