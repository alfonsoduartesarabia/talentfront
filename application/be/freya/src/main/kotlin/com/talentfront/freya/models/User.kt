package com.talentfront.freya.models

import com.talentfront.freya.search.models.Entry
import com.talentfront.freya.search.models.EntryType
import com.talentfront.jooq.tables.records.UserRecord

data class User(
    val id: Int? = null,
    val email: String? = null,
    val saltPasswordHash: ByteArray? = null,
    val salt: ByteArray? = null,
    val userTypeId: Int? = null,
    val firstName: String? = null,
    val lastName: String? = null
) {
    fun toEntry(): Entry {
        val fullName = "${this.firstName} ${this.lastName}"
        return Entry(type = EntryType.USER.name, title = fullName, description = this.generateDescription(), link = "/profile/${this.id}")
    }

    private fun generateDescription(): String {
        return "Is currently open to suitable positions"
    }

    companion object {
        fun UserRecord.toUser(): User {
            return User(
                id = this.userId,
                email = this.email,
                saltPasswordHash = this.saltPasswordHash,
                salt = this.salt,
                userTypeId = this.userTypeId,
                firstName = this.firstName,
                lastName = this.lastName
            )
        }
    }
}
