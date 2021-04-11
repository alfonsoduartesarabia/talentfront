package com.talentfront.freya.login.models

data class LoginResponse(
    val userId: Int,
    val sessionCookie: String
)
