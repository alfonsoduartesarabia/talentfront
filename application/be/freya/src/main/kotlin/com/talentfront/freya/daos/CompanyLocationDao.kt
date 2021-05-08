package com.talentfront.freya.daos

import com.talentfront.jooq.tables.CompanyLocation.COMPANY_LOCATION
import com.talentfront.jooq.tables.records.CompanyLocationRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component

@Component
class CompanyLocationDao(
    private val dslContext: DSLContext
) {
    fun saveCompanyLocation(p_location: String, p_companyId: Int): CompanyLocationRecord {
        val record = dslContext.newRecord(COMPANY_LOCATION).apply {
            companyId = p_companyId
            location = p_location
        }
        record.store()
        return record
    }

    fun getLocationsForCompany(companyId: Int): List<CompanyLocationRecord> {
        return dslContext.select()
            .from(COMPANY_LOCATION)
            .where(COMPANY_LOCATION.COMPANY_ID.eq(companyId))
            .fetchArray()
            .map {
                it.into(COMPANY_LOCATION)
            }
    }
}
