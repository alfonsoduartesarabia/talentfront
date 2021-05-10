package com.talentfront.freya.apply

import com.talentfront.freya.config.Routes.Companion.APPLY
import com.talentfront.freya.daos.UserPostingApplyDao
import com.talentfront.freya.session.SessionService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ApplyController(
    private val sessionService: SessionService,
    private val userPostingApplyDao: UserPostingApplyDao
) {

    @GetMapping(value = ["$APPLY/{postingId}"])
    fun getUserApply(
        @CookieValue(value = SessionService.SESSION_COOKIE_NAME) cookieValue: String?,
        @RequestParam("cookie") cookieQuery: String?,
        @PathVariable(required = true, value = "postingId") postingId: Int,
    ): ResponseEntity<*> {
        val cookie = cookieQuery ?: cookieValue
        val userId = sessionService.getValidUserIdFromCookie(cookie) ?: return ResponseEntity.ok("expected cookie or path param")
        userPostingApplyDao.saveApply(userId, postingId)
        return ResponseEntity.ok("saved apply")
    }
}
