package com.talentfront.freya.models

import com.talentfront.freya.search.models.Entry
import com.talentfront.freya.search.models.EntryType
import com.talentfront.jooq.tables.records.UserExperienceRecord

class UserExperience(
    val jobTitle: String? = null,
    val company: String? = null,
    val user: User? = null
) {

    fun toEntry(): Entry {
        val fullName = "${user?.firstName} ${user?.lastName}"
        return Entry(type = EntryType.USER.name, title = fullName, description = this.generateDescription(), link = "/profile/${user?.id}")
    }

    private fun generateDescription(): String {
        return "Works as a ${this.jobTitle ?: "engineer"} for ${this.company ?: ""}"
    }

    companion object {
        fun UserExperienceRecord.toUserExperience(user: User?): UserExperience {
            return UserExperience(
                jobTitle = this.jobTitle,
                company = this.company,
                user = user
            )
        }
    }
}
