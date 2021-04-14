package com.talentfront.freya.daos

import com.talentfront.jooq.tables.UserExperience.USER_EXPERIENCE
import com.talentfront.jooq.tables.records.UserExperienceRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.LocalDate.now

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
