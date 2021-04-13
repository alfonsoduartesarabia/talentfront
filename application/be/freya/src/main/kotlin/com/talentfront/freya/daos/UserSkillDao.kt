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

    fun saveSkill(p_userId: Int, p_skill: String): Int {
        val record = dslContext.newRecord(USER_SKILL).apply {
            userId = p_userId
            skill = p_skill
        }
        record.store()
        return record.userSkillId
    }

    fun removeSkill(p_userId: Int, p_skill: String) {
        dslContext.deleteFrom(USER_SKILL)
            .where(USER_SKILL.USER_ID.eq(p_userId))
            .and(USER_SKILL.SKILL.like(p_skill))
            .execute()
    }
}
