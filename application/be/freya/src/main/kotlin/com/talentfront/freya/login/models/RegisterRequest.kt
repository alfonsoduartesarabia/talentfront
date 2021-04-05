package com.talentfront.freya.login.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.talentfront.freya.models.User
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.SecureRandom

@JsonIgnoreProperties(ignoreUnknown = true)
data class RegisterRequest(
    val email: String? = null,
    val password: String? = null,
    val userType: String? = null,
    val firstName: String? = null,
    val lastName: String? = null
) {
    companion object {
        fun RegisterRequest.toUser(): User? {
            if (this.email.isNullOrBlank() ||
                this.password.isNullOrBlank() ||
                this.userType.isNullOrBlank() ||
                this.firstName.isNullOrBlank()
            ) {
                return null
            }
            val random = SecureRandom()
            val salt = ByteArray(16)
            random.nextBytes(salt)
            val md = MessageDigest.getInstance("SHA-512")
            md.update(salt)
            val hashedPassword = md.digest(this.password.toByteArray(StandardCharsets.UTF_8))
            val userTypeId = when (this.userType.toLowerCase()) {
                "talent" -> 1
                "professor" -> 2
                "recruiter" -> 3
                "company" -> 4
                else -> null
            } ?: return null
            return User(
                email = this.email.toLowerCase(),
                saltPasswordHash = hashedPassword,
                salt = salt,
                userTypeId = userTypeId,
                firstName = this.firstName,
                lastName = this.lastName ?: ""
            )
        }
    }
}
