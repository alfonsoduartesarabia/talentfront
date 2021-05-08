package com.talentfront.freya.user.models

data class UserProfileResponse(
    val firstName: String? = null,
    val lastName: String? = null,
    val userType: String? = null,
    val companyName: String? = null,
    val degree: String? = null,
    val skills: Array<String>? = null,
    val experiences: Array<Experience>? = null,
    val educations: Array<EducationResponse>? = null,
    val reviews: Array<ReviewResponse>? = null,
    val isProfessor: Boolean = false
)

data class Experience(
    val title: String? = null,
    val company: String? = null,
    val startDt: String? = null,
    val endDt: String? = null,
    val description: String? = null
)

data class EducationResponse(
    val school: String? = null,
    val degreeType: String? = null,
    val major: String? = null
)

data class ReviewResponse(
    val reviewerName: String? = null,
    val review: String? = null,
    val link: String? = null
)
