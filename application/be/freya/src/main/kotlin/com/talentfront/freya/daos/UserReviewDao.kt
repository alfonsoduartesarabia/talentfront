package com.talentfront.freya.daos

import com.talentfront.freya.userreview.models.UserReviewRequest
import com.talentfront.jooq.tables.UserReview.USER_REVIEW
import com.talentfront.jooq.tables.records.UserReviewRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component

@Component
class UserReviewDao(
    private val dslContext: DSLContext
) {
    fun savePosting(p_reviewerId: Int, userReviewRequest: UserReviewRequest): UserReviewRecord? {
        val record = dslContext.newRecord(USER_REVIEW).apply {
            reviewerId = p_reviewerId
            revieweeId = userReviewRequest.revieweeId
            reviewData = userReviewRequest.review
        }
        record.store()
        return record
    }

    fun getReviews(userId: Int): List<UserReviewRecord> {
        return dslContext.select()
            .from(USER_REVIEW)
            .where(USER_REVIEW.REVIEWEE_ID.eq(userId))
            .fetchArray()
            .map {
                it.into(USER_REVIEW)
            }
    }
}
