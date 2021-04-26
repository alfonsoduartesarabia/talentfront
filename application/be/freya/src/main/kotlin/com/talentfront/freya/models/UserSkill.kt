package com.talentfront.freya.models

import com.talentfront.freya.search.models.Entry
import com.talentfront.freya.search.models.EntryType
import com.talentfront.jooq.tables.records.UserSkillRecord

class UserSkill(
    val skill: String? = null,
    val user: User? = null
) {

    fun toEntry(): Entry {
        val fullName = "${user?.firstName} ${user?.lastName}"
        return Entry(type = EntryType.USER.name, title = fullName, description = this.generateDescription(), link = "/profile/${user?.id}")
    }

    private fun generateDescription(): String {
        return "Lists ${this.skill} as one of their proficiencies"
    }

    companion object {
        fun UserSkillRecord.toUserSkill(user: User?): UserSkill {
            return UserSkill(
                skill = this.skill,
                user = user
            )
        }
    }
}
