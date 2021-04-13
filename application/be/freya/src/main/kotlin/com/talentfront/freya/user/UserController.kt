package com.talentfront.freya.user

import com.talentfront.freya.config.Routes
import com.talentfront.freya.daos.UserSkillDao
import com.talentfront.freya.session.SessionService
import com.talentfront.freya.user.models.UserProfileResponse
import com.talentfront.freya.user.models.UserSkillsRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val sessionService: SessionService,
    private val userService: UserService,
    private val userSkillsDao: UserSkillDao
) {

    @GetMapping(value = ["${Routes.USER}/{userId}", Routes.USER])
    fun getUser(
        @CookieValue(value = SessionService.SESSION_COOKIE_NAME) cookieValue: String?,
        @PathVariable(required = false, value = "userId") userId: Int?
    ): ResponseEntity<*> {
        val userProfileResponse: UserProfileResponse = if (userId != null) {
            userService.getUserInfo(userId) ?: return ResponseEntity.ok("no user found for given path param")
        } else {
            val userIdFromCookie =
                sessionService.getValidUserIdFromCookie(cookieValue) ?: return ResponseEntity.ok("expected cookie or path param")
            userService.getUserInfo(userIdFromCookie) ?: return ResponseEntity.ok("no user found for given coookie userid")
        }
        return ResponseEntity.ok(userProfileResponse)
    }

    @PostMapping(value = [Routes.USER_SKILL])
    fun postUserSkills(
        @CookieValue(value = SessionService.SESSION_COOKIE_NAME) cookieValue: String?,
        @RequestBody userSkillsRequest: UserSkillsRequest
    ): ResponseEntity<*> {
        val userId = sessionService.getValidUserIdFromCookie(cookieValue) ?: return ResponseEntity.ok("expected cookie or path param")
        val alreadySkills = userSkillsDao.getUserSkillsByUserId(userId).map { record -> record.skill.toLowerCase() }
        userSkillsRequest.add?.forEach { skill ->
            if (!alreadySkills.contains(skill.toLowerCase())) userSkillsDao.saveSkill(userId, skill.toLowerCase())
        }
        userSkillsRequest.remove?.forEach { skill -> userSkillsDao.removeSkill(userId, skill.toLowerCase()) }
        val fullSkillList = userSkillsDao.getUserSkillsByUserId(userId).map { record -> record.skill.toLowerCase() }
        return ResponseEntity.ok(fullSkillList)
    }

//    @PostMapping(value = [Routes.USER_EDUCATION])
//    fun postUserEducation(
//        @CookieValue(value = SessionService.SESSION_COOKIE_NAME) cookieValue: String?,
//        @RequestBody userEducationRequest: UserEducationRequest
//    ): ResponseEntity<*> {
// //        val userId = sessionService.getValidUserIdFromCookie(cookieValue) ?: return ResponseEntity.ok("expected cookie or path param")
//        val userId = 7
//    }
}
