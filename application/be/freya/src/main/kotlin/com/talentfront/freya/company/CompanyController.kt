package com.talentfront.freya.company

import com.talentfront.freya.company.models.CompanyRequest
import com.talentfront.freya.company.models.CompanyResponse
import com.talentfront.freya.config.Routes.Companion.COMPANY
import com.talentfront.freya.daos.CompanyDao
import com.talentfront.freya.daos.CompanyLocationDao
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CompanyController(
    private val companyDao: CompanyDao,
    private val companyLocationDao: CompanyLocationDao
) {

    @PostMapping(value = [COMPANY])
    fun postCompany(
        @RequestBody request: CompanyRequest
    ): ResponseEntity<*> {
        val companyRecord = companyDao.saveCompany(request)
        request.locations?.forEach { companyLocationDao.saveCompanyLocation(it, companyRecord.companyId) }
        val locationsList = companyLocationDao.getLocationsForCompany(companyRecord.companyId).map { record -> record.location }.toTypedArray()
        val companyResponse = CompanyResponse(
            companyId = companyRecord.companyId,
            companyName = companyRecord.companyName,
            mission = companyRecord.mission,
            product = companyRecord.product,
            numberEmployees = companyRecord.numberEmployees,
            locations = locationsList
        )
        return ResponseEntity.ok(companyResponse)
    }

    @GetMapping(value = ["$COMPANY/{companyId}"])
    fun getCompany(@PathVariable companyId: Int): ResponseEntity<*> {
        val companyRecord = companyDao.getCompany(companyId) ?: return ResponseEntity.ok("No company found for id")
        val locationsList = companyLocationDao.getLocationsForCompany(companyId).map { record -> record.location }.toTypedArray()
        val companyResponse = CompanyResponse(
            companyId = companyId,
            companyName = companyRecord.companyName,
            mission = companyRecord.mission,
            product = companyRecord.product,
            numberEmployees = companyRecord.numberEmployees,
            locations = locationsList
        )
        return ResponseEntity.ok(companyResponse)
    }
}
