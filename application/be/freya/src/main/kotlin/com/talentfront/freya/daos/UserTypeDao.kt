package com.talentfront.freya.daos

import com.talentfront.jooq.Tables.USER_TYPE
import org.jooq.DSLContext
import org.springframework.stereotype.Component

@Component
class UserTypeDao(
    private val dslContext: DSLContext
) {
    fun getUserTypeByd(userTypeId: Int?): String? {
        userTypeId ?: return null
        val record = dslContext.select()
            .from(USER_TYPE)
            .where(USER_TYPE.USER_TYPE_ID.eq(userTypeId))
            .fetchOne() ?: return null

        return record.into(USER_TYPE)
            .type
    }
}
