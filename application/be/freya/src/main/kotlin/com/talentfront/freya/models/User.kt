package com.talentfront.freya.models

import com.talentfront.jooq.tables.records.UserRecord

data class User(
    val id: Int? = null,
    val email: String? = null,
    val saltPasswordHash: String? = null,
    val salt: String? = null,
    val userTypeId: Int? = null,
    val firstName: String? = null,
    val lastName: String? = null
) {
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
