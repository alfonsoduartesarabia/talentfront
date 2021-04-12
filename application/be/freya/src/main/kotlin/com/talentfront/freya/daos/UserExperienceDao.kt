package com.talentfront.freya.daos

import com.talentfront.jooq.tables.UserExperience.USER_EXPERIENCE
import com.talentfront.jooq.tables.records.UserExperienceRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component

@Component
class UserExperienceDao(
    private val dslContext: DSLContext
) {

    fun getUserExperiencesByUserId(userId: Int): List<UserExperienceRecord> {
        return dslContext.select()
            .from(USER_EXPERIENCE)
            .where(USER_EXPERIENCE.USER_ID.eq(userId))
            .orderBy(USER_EXPERIENCE.USER_EXEPERINCE_ID.desc())
            .fetchArray()
            .map {
                it.into(USER_EXPERIENCE)
            }
    }
}
