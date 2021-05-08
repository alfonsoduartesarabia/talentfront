package com.talentfront.freya.daos

import com.talentfront.freya.models.User.Companion.toUser
import com.talentfront.freya.models.UserSkill
import com.talentfront.freya.models.UserSkill.Companion.toUserSkill
import com.talentfront.jooq.Tables.USER_SKILL
import com.talentfront.jooq.tables.User
import com.talentfront.jooq.tables.records.UserRecord
import com.talentfront.jooq.tables.records.UserSkillRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component

@Component
class UserSkillDao(
    private val dslContext: DSLContext
) {

    fun searchUserSkills(search: String): List<UserSkill> {
        val terms = search.split("\\s".toRegex())
        val list = mutableListOf<UserSkill>()
        terms.forEach { term ->
            dslContext.select()
                .from(USER_SKILL)
                .join(User.USER).on(USER_SKILL.USER_ID.eq(User.USER.USER_ID))
                .where(USER_SKILL.SKILL.like("%$term%"))
                .orderBy(USER_SKILL.USER_ID.asc())
                .fetchArray()
                .map {
                    list.add(makeDomainUserSkillRecord(it.into(USER_SKILL), it.into(User.USER)))
                }
        }
        return list
    }

    private fun makeDomainUserSkillRecord(userSkillRecord: UserSkillRecord, userRecord: UserRecord): UserSkill {
        return userSkillRecord.toUserSkill(userRecord.toUser())
    }

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
