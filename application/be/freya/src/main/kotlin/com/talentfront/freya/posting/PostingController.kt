package com.talentfront.freya.posting

import com.talentfront.freya.config.Routes
import com.talentfront.freya.daos.PostingDao
import com.talentfront.freya.daos.PostingRequirementDao
import com.talentfront.freya.posting.models.PostingRequest
import com.talentfront.freya.posting.models.PostingRequest.Companion.toPosting
import com.talentfront.freya.posting.models.PostingResponse
import com.talentfront.freya.session.SessionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestBody
import java.text.NumberFormat

@RestController
class PostingController(
    private val postingDao: PostingDao,
    private val postingRequirementDao: PostingRequirementDao,
    private val sessionService: SessionService
) {
    private val format = NumberFormat.getCompactNumberInstance()

    @GetMapping(value = ["${Routes.POSTING}/{postingId}"])
    fun getPosting(@PathVariable postingId: Int): ResponseEntity<*> {
        val posting = postingDao.getPosting(postingId) ?: return ResponseEntity.ok("no posting found for given path param")
        val postingReqs = postingRequirementDao.getPostingRequirementsForPosting(postingId)
        val salaryRange = if (posting.salaryRangeBottom != 0) {
            "${format.format(posting.salaryRangeBottom)} - ${format.format(posting.salaryRangeTop)}"
        } else {
            ""
        }
        val postingResponse = PostingResponse(
            postingId = postingId,
            jobTitle = posting.jobTitle,
            companyName = posting.employerName,
            salaryRange = salaryRange,
            description = posting.description,
            requirements = postingReqs.map { req -> req.requirement }.toTypedArray(),
            datePosted = "${posting.createdDt.month.name.camelCase()} ${posting.createdDt.dayOfMonth}, ${posting.createdDt.year}",
            state = posting.state,
            city = posting.city
        )
        return ResponseEntity.ok(postingResponse)
    }

    private fun String.camelCase(): String {
        val lowerCase = this.toLowerCase()
        return lowerCase.replaceRange(0, 1, "${lowerCase[0].toUpperCase()}")
    }

    @PostMapping(value = [Routes.POSTING])
    fun postPosting(
        @CookieValue(value = SessionService.SESSION_COOKIE_NAME) cookieValue: String?,
        @RequestParam("cookie") cookieQuery: String?,
        @RequestBody request: PostingRequest
    ): ResponseEntity<*> {
        val userId = sessionService.getValidUserIdFromCookie(cookieQuery ?: cookieValue)
            ?: return ResponseEntity.ok("No user found for given cookie")
        val posting = request.toPosting(userId)
        val postingRecord = postingDao.savePosting(posting)
        request.requirements?.forEach {
            postingRequirementDao.savePostingRequirment(postingRecord!!.postingId, it)
        }
        val salaryRange = if (posting.salaryRangeBottom != 0) {
            "${format.format(posting.salaryRangeBottom)} - ${format.format(posting.salaryRangeTop)}"
        } else {
            ""
        }
        val postingResponse = PostingResponse(
            postingId = postingRecord!!.postingId,
            jobTitle = postingRecord.jobTitle,
            companyName = postingRecord.employerName,
            salaryRange = salaryRange,
            description = posting.description ?: "",
            requirements = request.requirements?.toTypedArray(),
            datePosted = "${postingRecord.createdDt?.month?.name?.camelCase()} ${postingRecord.createdDt?.dayOfMonth}, ${postingRecord.createdDt?.year}",
            state = postingRecord.state,
            city = postingRecord.city
        )
        return ResponseEntity.ok(postingResponse)
    }
}
