package com.talentfront.freya.daos

import com.talentfront.jooq.tables.UserCompany.USER_COMPANY
import com.talentfront.jooq.tables.records.UserCompanyRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component

@Component
class UserCompanyDao(
    private val dslContext: DSLContext
) {
    fun findLatestByUserId(userId: Int): UserCompanyRecord? {
        val record = dslContext.select()
            .from(USER_COMPANY)
            .where(USER_COMPANY.USER_ID.eq(userId))
            .orderBy(USER_COMPANY.USER_COMPANY_ID.desc())
            .limit(1)
            .fetchOne() ?: return null
        return record.into(USER_COMPANY)
    }
}
