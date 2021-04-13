package com.talentfront.freya.util

import com.talentfront.freya.session.SessionService
import org.springframework.stereotype.Component

@Component
class UserIdUtil(
    private val sessionService: SessionService
) {
    fun getUserId(
        pathUserId: Int?,
        cookieValue: String?,
        cookieQuery: String?
    ): Int? {
        return pathUserId ?: sessionService.getValidUserIdFromCookie(cookieQuery ?: cookieValue)
    }
}
