package com.talentfront.freya.login

import com.talentfront.freya.config.Routes.Companion.LOGIN
import com.talentfront.freya.config.Routes.Companion.REGISTER
import com.talentfront.freya.daos.UserDao
import com.talentfront.freya.daos.UserSessionDao
import com.talentfront.freya.login.models.LoginRequest
import com.talentfront.freya.login.models.LoginResponse
import com.talentfront.freya.login.models.RegisterRequest
import com.talentfront.freya.login.models.RegisterRequest.Companion.toUser
import com.talentfront.freya.login.models.RegisterResponse
import com.talentfront.freya.models.User
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.security.MessageDigest
import java.util.*
import org.springframework.http.ResponseCookie

@RestController
class LoginController(
    private val userDao: UserDao,
    private val userSessionDao: UserSessionDao
) {

    @PostMapping(value = [REGISTER])
    fun register(@RequestBody registerRequest: RegisterRequest): ResponseEntity<*> {
        if (
            registerRequest.email.isNullOrBlank() ||
            registerRequest.password.isNullOrBlank() ||
            registerRequest.userType.isNullOrBlank() ||
            registerRequest.firstName.isNullOrBlank() ||
            registerRequest.userType.isNullOrBlank()
        ) {
            return ResponseEntity("Missing Required Fields", HttpStatus.BAD_REQUEST)
        }
        if (userDao.findByEmail(registerRequest.email.toLowerCase()) != null) {
            return ResponseEntity("Email Already Exists", HttpStatus.BAD_REQUEST)
        }
        val user = registerRequest.toUser() ?: return ResponseEntity("UserType failure, UserType must match one of: talent, professor, recruiter, company", HttpStatus.BAD_REQUEST)
        val savedUser = userDao.saveUser(user)
        val headers = HttpHeaders()
        headers.set(HttpHeaders.SET_COOKIE, getUserSessionCookie(savedUser).toString())
        return ResponseEntity.ok()
            .headers(headers)
            .body(RegisterResponse(userId = savedUser.id!!))
    }

    @PostMapping(value = [LOGIN])
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<*> {
        if (
            loginRequest.email.isNullOrBlank() ||
            loginRequest.password.isNullOrBlank()
        ) {
            return ResponseEntity("Missing Required Fields", HttpStatus.BAD_REQUEST)
        }
        val user = userDao.findByEmail(loginRequest.email.toLowerCase()) ?: return ResponseEntity("No matching info", HttpStatus.BAD_REQUEST)
        return if (verifyPassword(loginRequest.password, user)) {
            val headers = HttpHeaders()
            headers.set(HttpHeaders.SET_COOKIE, getUserSessionCookie(user).toString())
            return ResponseEntity.ok()
                .headers(headers)
                .body(LoginResponse(user.id!!))
        } else {
            ResponseEntity("No matching info", HttpStatus.BAD_REQUEST)
        }
    }

    private fun verifyPassword(password: String, user: User): Boolean {
        val md = MessageDigest.getInstance("SHA-512")
        md.update(user.salt)
        val hashedPassword = md.digest(password.toByteArray())
        return hashedPassword.contentEquals(user.saltPasswordHash)
    }

    private fun getUserSessionCookie(user: User): ResponseCookie {
        val verification = UUID.randomUUID().toString()
        userSessionDao.saveSession(user, verification)

        val value = "${user.id}_${verification}"

        return ResponseCookie.from("talentfront-session", value)
            .httpOnly(true)
            .secure(true)
            .path("/")
            .maxAge(7 * 24 * 60 * 60)
            .build()
    }
}
