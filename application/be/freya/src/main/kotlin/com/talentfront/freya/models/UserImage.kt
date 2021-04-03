package com.talentfront.freya.models

import java.time.LocalDateTime

data class UserImage(
    val id: Int? = null,
    val userId: Int? = null,
    val img: ByteArray? = null,
    val title: String? = null,
    val created_dt: LocalDateTime? = null
)
