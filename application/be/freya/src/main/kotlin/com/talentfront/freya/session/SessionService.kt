package com.talentfront.freya.session

import com.talentfront.freya.daos.UserSessionDao
import com.talentfront.freya.models.User
import org.springframework.http.ResponseCookie
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SessionService(
    private val userSessionDao: UserSessionDao
) {
    companion object {
        const val SESSION_COOKIE_NAME = "talentfront-session"
    }

    fun getUserSessionCookie(user: User): ResponseCookie {
        val verification = UUID.randomUUID().toString()
        userSessionDao.saveSession(user, verification)

        val value = "${user.id}_$verification"

        return ResponseCookie.from(SESSION_COOKIE_NAME, value)
            .secure(false)
            .sameSite("none")
            .path("/")
            .maxAge(7 * 24 * 60 * 60)
            .build()
    }

    fun getValidUserIdFromCookie(session: String?): Int? {
        session ?: return null
        return try {
            val userId = session.substring(0, session.indexOfFirst { c -> c == '_' }).toInt()
            val validation = session.substring(session.indexOfFirst { c -> c == '_' } + 1)
            if (userSessionDao.getIsVerified(userId, validation)) {
                userId
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
}
