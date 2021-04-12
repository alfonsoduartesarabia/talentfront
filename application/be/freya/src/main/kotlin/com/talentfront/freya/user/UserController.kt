package com.talentfront.freya.user

import com.talentfront.freya.config.Routes
import com.talentfront.freya.session.SessionService
import com.talentfront.freya.user.models.UserProfileResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val sessionService: SessionService,
    private val userService: UserService
) {

    @GetMapping(value = ["${Routes.USER}/{userId}", Routes.USER])
    fun getUser(@CookieValue(value = SessionService.SESSION_COOKIE_NAME) cookieValue: String?, @PathVariable(required = false, value = "userId") userId: Int?): ResponseEntity<*> {
        val userProfileResponse: UserProfileResponse = if (userId != null) {
            userService.getUserInfo(userId) ?: return ResponseEntity.ok("no user found for given path param")
        } else {
            val userIdFromCookie = sessionService.getValidUserIdFromCookie(cookieValue) ?: return ResponseEntity.ok("expected cookie or path param")
            userService.getUserInfo(userIdFromCookie) ?: return ResponseEntity.ok("no user found for given coookie userid")
        }
        return ResponseEntity.ok(userProfileResponse)
    }
}
