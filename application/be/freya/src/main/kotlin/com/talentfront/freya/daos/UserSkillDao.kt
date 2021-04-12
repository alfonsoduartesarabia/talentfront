package com.talentfront.freya.daos

import com.talentfront.jooq.Tables.USER_SKILL
import com.talentfront.jooq.tables.records.UserSkillRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component

@Component
class UserSkillDao(
    private val dslContext: DSLContext
) {
    fun getUserSkillsByUserId(userId: Int): List<UserSkillRecord> {
        return dslContext.select()
            .from(USER_SKILL)
            .where(USER_SKILL.USER_ID.eq(userId))
            .orderBy(USER_SKILL.USER_SKILL_ID.desc())
            .fetchArray()
            .map {
                it.into(USER_SKILL)
            }
    }
}
