package com.talentfront.freya.posting.models

data class PostingResponse(
    val postingId: Int,
    val jobTitle: String,
    val companyName: String,
    val salaryRange: String,
    val description: String,
    val requirements: Array<String>? = null,
    val datePosted: String,
    val state: String,
    val city: String,
)
