package com.talentfront.freya.daos

import com.talentfront.freya.models.User
import com.talentfront.freya.models.User.Companion.toUser
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
        return userRecord.toUser()
    }

    fun findByEmail(email: String): User? {
        val record = dslContext.select()
            .from(USER)
            .where(USER.EMAIL.eq(email))
            .orderBy(USER.USER_ID.asc())
            .limit(1)
            .fetchOne() ?: return null
        return record.into(USER).toUser()
    }
}
