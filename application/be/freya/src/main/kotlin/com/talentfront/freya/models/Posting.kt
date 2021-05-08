package com.talentfront.freya.models

import com.talentfront.freya.search.models.Entry
import com.talentfront.freya.search.models.EntryType
import java.time.LocalDateTime

data class Posting(
    val id: Int? = null,
    val description: String? = null,
    val employerName: String? = null,
    val salaryRangeTop: Int? = null,
    val salaryRangeBottom: Int? = null,
    val createdDt: LocalDateTime? = null,
    val userId: Int? = null,
    val jobTitle: String? = null,
    val state: String? = null,
    val city: String? = null,
) {
    fun toEntry(): Entry {
        return Entry(type = EntryType.POSTING.name, title = "${this.employerName}: ${this.jobTitle}", description = this.description, link = "/posting/${this.id}")
    }
}
