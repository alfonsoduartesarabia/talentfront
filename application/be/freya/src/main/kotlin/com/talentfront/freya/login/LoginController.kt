package com.talentfront.freya.login

import com.talentfront.freya.config.Routes.Companion.LOGIN
import com.talentfront.freya.config.Routes.Companion.REGISTER
import com.talentfront.freya.daos.UserDao
import com.talentfront.freya.login.models.LoginRequest
import com.talentfront.freya.login.models.LoginResponse
import com.talentfront.freya.login.models.RegisterRequest
import com.talentfront.freya.login.models.RegisterRequest.Companion.toUser
import com.talentfront.freya.login.models.RegisterResponse
import com.talentfront.freya.models.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.security.MessageDigest

@RestController
class LoginController(
    private val userDao: UserDao
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
        return ResponseEntity.ok(RegisterResponse(userId = savedUser.id!!))
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
            ResponseEntity.ok(LoginResponse(user.id!!))
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
}
