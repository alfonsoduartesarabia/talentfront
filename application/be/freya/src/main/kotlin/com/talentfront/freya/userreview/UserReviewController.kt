package com.talentfront.freya.userreview

import com.talentfront.freya.config.Routes.Companion.USER_REVIEW
import com.talentfront.freya.daos.UserReviewDao
import com.talentfront.freya.session.SessionService
import com.talentfront.freya.userreview.models.UserReviewRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserReviewController(
    private val sessionService: SessionService,
    private val userReviewDao: UserReviewDao

) {
    @PostMapping(value = [USER_REVIEW])
    fun postReview(
        @CookieValue(value = SessionService.SESSION_COOKIE_NAME) cookieValue: String?,
        @RequestParam("cookie") cookieQuery: String?,
        @RequestBody userReviewRequest: UserReviewRequest
    ): ResponseEntity<*> {
        val cookie = cookieQuery ?: cookieValue
        val userId = sessionService.getValidUserIdFromCookie(cookie) ?: return ResponseEntity.ok("expected cookie or path param")
        if (userReviewRequest.revieweeId == null || userReviewRequest.review.isNullOrBlank()) {
            return ResponseEntity.ok("missing reviewee id or review data")
        }
        userReviewDao.savePosting(userId, userReviewRequest)
        return ResponseEntity.ok("saved")
    }
}
