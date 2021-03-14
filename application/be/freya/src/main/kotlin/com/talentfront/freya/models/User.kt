package com.talentfront.freya.models

data class User(
    val id: Int? = null,
    val email: String? = null,
    val saltPasswordHash: String? = null,
    val salt: String? = null,
    val userTypeId: Int? = null,
    val firstName: String? = null,
    val lastName: String? = null
)
