package com.talentfront.freya.daos

import com.talentfront.freya.models.User.Companion.toUser
import com.talentfront.freya.models.UserEducation
import com.talentfront.freya.models.UserEducation.Companion.toUserEducation
import com.talentfront.jooq.tables.User.USER
import com.talentfront.jooq.tables.UserEducation.USER_EDUCATION
import com.talentfront.jooq.tables.records.UserEducationRecord
import com.talentfront.jooq.tables.records.UserRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component

@Component
class UserEducationDao(
    private val dslContext: DSLContext
) {
    fun getUserEducations(seek: Int, limit: Int): List<UserEducation> {
        return dslContext.select()
            .from(USER_EDUCATION)
            .join(USER).on(USER_EDUCATION.USER_ID.eq(USER.USER_ID))
            .orderBy(USER_EDUCATION.USER_EDUCATION_ID.asc())
            .seek(seek)
            .limit(limit)
            .fetchArray()
            .map {
                makeDomainUserEducation(it.into(USER_EDUCATION), it.into(USER))
            }
    }

    private fun makeDomainUserEducation(userEducationRecord: UserEducationRecord, userRecord: UserRecord): UserEducation {
        return userEducationRecord.toUserEducation(userRecord.toUser())
    }
}
