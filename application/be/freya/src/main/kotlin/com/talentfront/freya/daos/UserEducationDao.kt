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

    fun getUserEducations(): List<UserEducation> {
        return dslContext.select()
            .from(USER_EDUCATION)
            .join(USER).on(USER_EDUCATION.USER_ID.eq(USER.USER_ID))
            .orderBy(USER_EDUCATION.USER_EDUCATION_ID.asc())
            .fetchArray()
            .map {
                makeDomainUserEducation(it.into(USER_EDUCATION), it.into(USER))
            }
    }

    fun getUserEducations(searchTerm: String): List<UserEducation> {
        val terms = searchTerm.split("\\s".toRegex())
        val list = mutableListOf<UserEducation>()
        terms.forEach { term ->
            dslContext.select()
                .from(USER_EDUCATION)
                .join(USER).on(USER_EDUCATION.USER_ID.eq(USER.USER_ID))
                .where(USER_EDUCATION.SCHOOL.like("%$term%"))
                .orderBy(USER_EDUCATION.USER_EDUCATION_ID.asc())
                .fetchArray()
                .map {
                    list.add(makeDomainUserEducation(it.into(USER_EDUCATION), it.into(USER)))
                }
        }
        return list
    }

    private fun makeDomainUserEducation(userEducationRecord: UserEducationRecord, userRecord: UserRecord): UserEducation {
        return userEducationRecord.toUserEducation(userRecord.toUser())
    }

    fun getUserEducationsByUserId(userId: Int): List<UserEducationRecord> {
        return dslContext.select()
            .from(USER_EDUCATION)
            .where(USER_EDUCATION.USER_ID.eq(userId))
            .orderBy(USER_EDUCATION.USER_EDUCATION_ID.desc())
            .fetchArray()
            .map {
                it.into(USER_EDUCATION)
            }
    }

    fun saveUserEducationRecord(p_userId: Int, p_degreeType: String, p_school: String, p_major: String?, p_state: String): Int {
        val record = dslContext.newRecord(USER_EDUCATION).apply {
            school = p_school
            degreeType = p_degreeType
            major = p_major
            state = p_state
            userId = p_userId
        }
        record.store()
        return record.userEducationId
    }
}
