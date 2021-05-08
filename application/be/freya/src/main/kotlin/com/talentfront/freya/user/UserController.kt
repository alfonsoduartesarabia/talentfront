package com.talentfront.freya.user

import com.talentfront.freya.config.Routes
import com.talentfront.freya.daos.UserCompanyDao
import com.talentfront.freya.daos.UserEducationDao
import com.talentfront.freya.daos.UserExperienceDao
import com.talentfront.freya.daos.UserSkillDao
import com.talentfront.freya.session.SessionService
import com.talentfront.freya.user.models.UserEducationRequest
import com.talentfront.freya.user.models.UserExperienceRequest
import com.talentfront.freya.user.models.UserProfileResponse
import com.talentfront.freya.user.models.UserSkillsRequest
import com.talentfront.freya.util.UserIdUtil
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val sessionService: SessionService,
    private val userService: UserService,
    private val userSkillsDao: UserSkillDao,
    private val userIdUtil: UserIdUtil,
    private val userEducationDao: UserEducationDao,
    private val userExperienceDao: UserExperienceDao,
    private val userCompanyDao: UserCompanyDao
) {

    @GetMapping(value = ["${Routes.USER}/{userId}", Routes.USER])
    fun getUser(
        @CookieValue(value = SessionService.SESSION_COOKIE_NAME) cookieValue: String?,
        @RequestParam("cookie") cookieQuery: String?,
        @PathVariable(required = false, value = "userId") pathUserId: Int?,
    ): ResponseEntity<*> {
        if (cookieValue == null && cookieQuery == null && pathUserId == null) return ResponseEntity.ok("expected cookie or path param")
        val mainUserId = userIdUtil.getUserId(pathUserId = pathUserId, cookieValue = cookieValue, cookieQuery = cookieQuery) ?: return ResponseEntity.ok("no user found")
        val cookieUserId = sessionService.getValidUserIdFromCookie(cookieQuery ?: cookieValue)
        val userProfileResponse: UserProfileResponse = userService.getUserInfo(mainUserId, cookieUserId) ?: return ResponseEntity.ok("no user found")
        return ResponseEntity.ok(userProfileResponse)
    }

    @PostMapping(value = [Routes.USER_SKILL])
    fun postUserSkills(
        @CookieValue(value = SessionService.SESSION_COOKIE_NAME) cookieValue: String?,
        @RequestParam("cookie") cookieQuery: String?,
        @RequestBody userSkillsRequest: UserSkillsRequest
    ): ResponseEntity<*> {
        val cookie = cookieQuery ?: cookieValue
        val userId = sessionService.getValidUserIdFromCookie(cookie) ?: return ResponseEntity.ok("expected cookie or path param")
        val alreadySkills = userSkillsDao.getUserSkillsByUserId(userId).map { record -> record.skill.toLowerCase() }
        userSkillsRequest.add?.forEach { skill ->
            if (!alreadySkills.contains(skill.toLowerCase())) userSkillsDao.saveSkill(userId, skill.toLowerCase())
        }
        userSkillsRequest.remove?.forEach { skill -> userSkillsDao.removeSkill(userId, skill.toLowerCase()) }
        val fullSkillList = userSkillsDao.getUserSkillsByUserId(userId).map { record -> record.skill.toLowerCase() }
        return ResponseEntity.ok(fullSkillList)
    }

    @PostMapping(value = [Routes.USER_EDUCATION])
    fun postUserEducation(
        @CookieValue(value = SessionService.SESSION_COOKIE_NAME) cookieValue: String?,
        @RequestParam("cookie") cookieQuery: String?,
        @RequestBody userEducationRequest: UserEducationRequest
    ): ResponseEntity<*> {
        val cookie = cookieQuery ?: cookieValue
        val userId = sessionService.getValidUserIdFromCookie(cookie) ?: return ResponseEntity.ok("expected cookie or path param")
        if (userEducationRequest.school == null || userEducationRequest.major == null) return ResponseEntity.ok("missing school or degree")
        val degreeType = when (userEducationRequest.degree?.toUpperCase()) {
            "BA" -> "Bachelor of Arts"
            "AA" -> "Associate in Arts"
            "M" -> "Masters"
            "MBA" -> "Master of Business Administration"
            "D" -> "Doctorate"
            "BS", null -> "Bachelor of Science"
            else -> "Bachelor of Science"
        }
        val state = when (userEducationRequest.isFinished) {
            true -> "Completed"
            false -> "In Progress"
            else -> "Completed"
        }
        userEducationDao.saveUserEducationRecord(userId, degreeType, userEducationRequest.school, userEducationRequest.major, state)
        return ResponseEntity.ok("Saved")
    }

    @PostMapping(value = [Routes.USER_EXPERIENCE])
    fun postUserExperience(
        @CookieValue(value = SessionService.SESSION_COOKIE_NAME) cookieValue: String?,
        @RequestParam("cookie") cookieQuery: String?,
        @RequestBody request: UserExperienceRequest
    ): ResponseEntity<*> {
        val cookie = cookieQuery ?: cookieValue
        val userId = sessionService.getValidUserIdFromCookie(cookie) ?: return ResponseEntity.ok("expected cookie or path param")
        if (request.title == null || request.company == null || request.description == null) return ResponseEntity.ok("missing job title, company or description")
        userExperienceDao.saveUserEducationRecord(userId, request.title, request.company, request.description, request.dateStart, request.dateEnd)
        userCompanyDao.saveUserCompany(userId, request.company)
        return ResponseEntity.ok("Saved")
    }
}
