package com.talentfront.freya.daos

import com.talentfront.freya.models.User
import com.talentfront.jooq.Tables.USER_SESSION
import org.jooq.DSLContext
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class UserSessionDao(
    private val dslContext: DSLContext
) {
    fun saveSession(user: User, verification2: String): Int {
        val userSessionRecord = dslContext.newRecord(USER_SESSION).apply {
            userId = user.id
            verification = verification2
            createdDt = LocalDateTime.now()
        }
        userSessionRecord.store()
        return userSessionRecord.userSessionId
    }

    fun getIsVerified(userId: Int, verification2: String): Boolean {
        val record = dslContext.select()
            .from(USER_SESSION)
            .where(USER_SESSION.USER_ID.eq(userId))
            .and(USER_SESSION.VERIFICATION.eq(verification2))
            .limit(1)
            .fetchOne()
            .into(USER_SESSION) ?: return false
        return true;
    }
}
