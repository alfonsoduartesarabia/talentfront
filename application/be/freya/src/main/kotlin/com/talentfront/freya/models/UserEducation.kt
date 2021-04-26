package com.talentfront.freya.models

import com.talentfront.freya.search.models.Entry
import com.talentfront.freya.search.models.EntryType
import com.talentfront.jooq.tables.records.UserEducationRecord

data class UserEducation(
    val id: Int? = null,
    val school: String? = null,
    val degreeType: DegreeType? = null,
    val state: State? = null,
    val user: User? = null
) {

    fun toEntry(): Entry {
        val fullName = "${user?.firstName} ${user?.lastName}"
        return Entry(type = EntryType.USER.name, title = fullName, description = this.generateDescription(), link = "/profile/${user?.id}")
    }

    private fun generateDescription(): String {
        return when (this.state) {
            State.PLANNED -> "Is planning to pursue an ${this.degreeType?.description ?: "degree"} from ${this.school ?: "San Francisco State University"}"
            State.IN_PROGRESS -> "Is pursuing an ${this.degreeType?.description ?: "degree"} from ${this.school ?: "San Francisco State University"}"
            State.COMPLETED -> "Has completed an ${this.degreeType?.description ?: "degree"} from ${this.school ?: "San Francisco State University"}"
            else -> "Error"
        }
    }

    companion object {
        fun UserEducationRecord.toUserEducation(user: User?): UserEducation {
            return UserEducation(
                id = this.userEducationId,
                school = this.school,
                degreeType = this.degreeType.determineDegreeType(),
                state = this.state.determineState(),
                user = user
            )
        }

        private fun String.determineDegreeType(): DegreeType? {
            return when (this) {
                "UNDER_GRAD" -> DegreeType.UNDER_GRAD
                "POST_GRAD" -> DegreeType.POST_GRAD
                else -> null
            }
        }

        private fun String.determineState(): State? {
            return when (this) {
                "PLANNED" -> State.PLANNED
                "IN_PROGRESS" -> State.IN_PROGRESS
                "COMPLETED" -> State.COMPLETED
                else -> null
            }
        }
    }
}

enum class DegreeType(val description: String) {
    UNDER_GRAD("undergraduate degree"),
    POST_GRAD("postgraduate degree")
}

enum class State {
    PLANNED,
    IN_PROGRESS,
    COMPLETED
}
