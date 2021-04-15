package com.talentfront.freya.posting.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.talentfront.freya.models.Posting
import java.math.BigDecimal
import java.time.LocalDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
class PostingRequest(
    val jobTitle: String,
    val companyName: String,
    val salaryTop: BigDecimal? = null,
    val salaryBottom: BigDecimal? = null,
    val description: String? = null,
    val requirements: List<String>? = null,
    val state: String? = null,
    val city: String? = null
) {
    companion object {
        fun PostingRequest.toPosting(userId: Int): Posting {
            return Posting(
                id = null,
                description = this.description,
                employerName =  this.companyName,
                salaryRangeTop = this.salaryTop?.toInt(),
                salaryRangeBottom = this.salaryBottom?.toInt(),
                createdDt = LocalDateTime.now(),
                userId = userId,
                jobTitle = this.jobTitle,
                state = this.state,
                city = this.city
            )
        }
    }
}
