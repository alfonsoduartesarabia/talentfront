package com.talentfront.freya.daos

import com.talentfront.jooq.tables.UserPostingApply.USER_POSTING_APPLY
import com.talentfront.jooq.tables.records.UserPostingApplyRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class UserPostingApplyDao(
    private val dslContext: DSLContext
) {
    fun saveApply(userId: Int, p_postingId: Int): UserPostingApplyRecord {
        val records = dslContext.select()
            .from(USER_POSTING_APPLY)
            .where(USER_POSTING_APPLY.APPLICANT_ID.eq(userId))
            .and(USER_POSTING_APPLY.POSTING_ID.eq(p_postingId))
            .fetchArray()
            .map {
                it.into(USER_POSTING_APPLY)
            }
        return if (records.isEmpty()) {
            val record = dslContext.newRecord(USER_POSTING_APPLY).apply {
                applicantId = userId
                postingId = p_postingId
                createdDt = LocalDateTime.now()
            }
            record.store()
            record
        } else {
            records[0]
        }
    }

    fun getAppliesForPosting(postingId: Int): List<UserPostingApplyRecord> {
        return dslContext.select()
            .from(USER_POSTING_APPLY)
            .where(USER_POSTING_APPLY.POSTING_ID.eq(postingId))
            .fetchArray()
            .map {
                it.into(USER_POSTING_APPLY)
            }
    }
}
