package com.talentfront.freya.daos

import com.talentfront.freya.models.Posting
import com.talentfront.jooq.tables.PostingRequirement.POSTING_REQUIREMENT
import com.talentfront.jooq.tables.records.PostingRecord
import com.talentfront.jooq.tables.records.PostingRequirementRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component

@Component
class PostingRequirementDao(
    private val dslContext: DSLContext
) {
    fun getPostingRequirementsForPosting(postingId: Int): List<PostingRequirementRecord> {
        return dslContext.select()
            .from(POSTING_REQUIREMENT)
            .where(POSTING_REQUIREMENT.POSTING_ID.eq(postingId))
            .fetchArray()
            .map {
                it.into(POSTING_REQUIREMENT)
            }
    }

    fun savePostingRequirment(p_postingId: Int, p_requirement: String): PostingRequirementRecord? {
        val record = dslContext.newRecord(POSTING_REQUIREMENT).apply {
            postingId = p_postingId
            requirement = p_requirement
        }
        record.store()
        return record
    }
}
