package com.talentfront.freya.daos

import com.talentfront.freya.models.User.Companion.toUser
import com.talentfront.freya.models.UserExperience
import com.talentfront.freya.models.UserExperience.Companion.toUserExperience
import com.talentfront.jooq.tables.User
import com.talentfront.jooq.tables.UserExperience.USER_EXPERIENCE
import com.talentfront.jooq.tables.records.UserExperienceRecord
import com.talentfront.jooq.tables.records.UserRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDate.now

@Component
class UserExperienceDao(
    private val dslContext: DSLContext
) {

    fun searchUserExperience(search: String): List<UserExperience> {
        val terms = search.split("\\s".toRegex())
        val list = mutableListOf<UserExperience>()
        terms.forEach { term ->
            dslContext.select()
                .from(USER_EXPERIENCE)
                .join(User.USER).on(USER_EXPERIENCE.USER_ID.eq(User.USER.USER_ID))
                .where(USER_EXPERIENCE.JOB_TITLE.like("%$term%"))
                .or(USER_EXPERIENCE.COMPANY.like("%$term%"))
                .orderBy(USER_EXPERIENCE.USER_ID.asc())
                .fetchArray()
                .map {
                    list.add(makeDomainUserSkillRecord(it.into(USER_EXPERIENCE), it.into(User.USER)))
                }
        }
        return list
    }

    private fun makeDomainUserSkillRecord(userExperienceRecord: UserExperienceRecord, userRecord: UserRecord): UserExperience {
        return userExperienceRecord.toUserExperience(userRecord.toUser())
    }

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

    fun saveUserEducationRecord(p_userId: Int, p_title: String?, p_company: String?, p_description: String?, start: LocalDate?, end: LocalDate?): Int {
        val record = dslContext.newRecord(USER_EXPERIENCE).apply {
            jobTitle = p_title
            company = p_company
            description = p_description ?: ""
            dateStart = start ?: now()
            dateEnd = end
            userId = p_userId
        }
        record.store()
        return record.userExeperinceId
    }
}
