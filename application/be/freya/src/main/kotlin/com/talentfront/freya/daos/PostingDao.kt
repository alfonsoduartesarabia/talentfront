package com.talentfront.freya.daos

import com.talentfront.freya.models.Posting
import com.talentfront.freya.models.User.Companion.toUser
import com.talentfront.jooq.tables.Posting.POSTING
import com.talentfront.jooq.tables.User
import com.talentfront.jooq.tables.records.PostingRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component

@Component
class PostingDao(
    private val dslContext: DSLContext
) {

    fun getPostings(seek: Int, limit: Int): List<Posting> {
        return dslContext.select()
            .from(POSTING)
            .orderBy(POSTING.POSTING_ID.asc())
            .seek(seek)
            .limit(limit)
            .fetchArray()
            .map {
                val record = it as PostingRecord
                record.toPosting()
            }
    }

    fun getPosting(id: Int): PostingRecord? {
        val record = dslContext.select()
            .from(POSTING)
            .where(POSTING.POSTING_ID.eq(id))
            .fetchOne() ?: null
        return record?.into(POSTING)
    }

    fun savePosting(posting: Posting): PostingRecord? {
        val record = dslContext.newRecord(POSTING).apply {
            description = posting.description
            employerName = posting.employerName
            salaryRangeTop = posting.salaryRangeTop
            salaryRangeBottom = posting.salaryRangeBottom
            createdDt = posting.createdDt
            userId = posting.userId
            jobTitle = posting.jobTitle
            state = posting.state
            city = posting.city
        }
        record.store()
        return record
    }

    fun searchPostings(searchTerm: String, seek: Int, limit: Int): List<Posting> {
        val terms = searchTerm.split("\\s".toRegex())
        val map = mutableMapOf<Int, Posting>()
        terms.forEach { term ->
            dslContext.select()
                .from(POSTING)
                .where(POSTING.JOB_TITLE.like("%$term%"))
                .fetchArray()
                .forEach {
                    val record = it as PostingRecord
                    map.putIfAbsent(record.postingId, record.toPosting())
                }
        }
        val list = map.values.toList()
        return if (list.size < seek) {
            emptyList()
        } else {
            list.subList(seek, minOf(seek + limit, list.size))
        }
    }

    fun PostingRecord.toPosting(): Posting {
        return Posting(
            id = this.postingId,
            description = this.description,
            employerName = this.employerName,
            salaryRangeTop = this.salaryRangeTop,
            salaryRangeBottom = this.salaryRangeBottom,
            createdDt = this.createdDt,
            userId = this.userId,
            jobTitle = this.jobTitle,
            state = this.state,
            city = this.city,
        )
    }
}
