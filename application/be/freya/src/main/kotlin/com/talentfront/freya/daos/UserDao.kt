package com.talentfront.freya.daos

import com.talentfront.freya.models.User
import com.talentfront.jooq.tables.User.USER
import org.jooq.DSLContext
import org.springframework.stereotype.Component

@Component
class UserDao(
    private val dslContext: DSLContext
) {
    fun saveUser(user: User): User {
        val userRecord = dslContext.newRecord(USER).apply {
            email = user.email
            saltPasswordHash = user.saltPasswordHash
            salt = user.salt
            userTypeId = user.userTypeId
            firstName = user.firstName
            lastName = user.lastName
        }
        userRecord.store()
        return user
    }
}
