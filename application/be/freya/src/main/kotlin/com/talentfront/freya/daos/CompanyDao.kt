package com.talentfront.freya.daos

import com.talentfront.freya.company.models.CompanyRequest
import com.talentfront.jooq.tables.Company.COMPANY
import com.talentfront.jooq.tables.records.CompanyRecord
import org.jooq.DSLContext
import org.springframework.stereotype.Component

@Component
class CompanyDao(
    private val dslContext: DSLContext
) {
    fun saveCompany(request: CompanyRequest): CompanyRecord {
        val record = dslContext.newRecord(COMPANY).apply {
            companyName = request.companyName
            mission = request.mission ?: ""
            product = request.product ?: ""
            numberEmployees = request.numberEmployees ?: 0
        }
        record.store()
        return record
    }

    fun getCompany(companyId: Int): CompanyRecord? {
        val record = dslContext.select()
            .from(COMPANY)
            .where(COMPANY.COMPANY_ID.eq(companyId))
            .fetchOne() ?: null
        return record?.into(COMPANY)
    }

    fun searchCompanies(searchTerm: String): List<CompanyRecord> {
        val terms = searchTerm.split("\\s".toRegex())
        val list = mutableListOf<CompanyRecord>()
        terms.forEach { term ->
            dslContext.select()
                .from(COMPANY)
                .where(COMPANY.COMPANY_NAME.like("%$term%"))
                .fetchArray()
                .forEach {
                    val record = it as CompanyRecord
                    list.add(record)
                }
        }
        return list
    }

    fun getCompanies(): List<CompanyRecord> {
        return dslContext.select()
            .from(COMPANY)
            .fetchArray()
            .map {
                it as CompanyRecord
            }
    }
}
