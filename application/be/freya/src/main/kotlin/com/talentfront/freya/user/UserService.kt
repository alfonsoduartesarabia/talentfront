package com.talentfront.freya.user

import com.talentfront.freya.daos.UserCompanyDao
import com.talentfront.freya.daos.UserDao
import com.talentfront.freya.daos.UserEducationDao
import com.talentfront.freya.daos.UserExperienceDao
import com.talentfront.freya.daos.UserSkillDao
import com.talentfront.freya.daos.UserTypeDao
import com.talentfront.freya.user.models.EducationResponse
import com.talentfront.freya.user.models.Experience
import com.talentfront.freya.user.models.UserProfileResponse
import com.talentfront.jooq.tables.records.UserEducationRecord
import com.talentfront.jooq.tables.records.UserExperienceRecord
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class UserService(
    private val userDao: UserDao,
    private val userCompanyDao: UserCompanyDao,
    private val userEducationDao: UserEducationDao,
    private val userSkillDao: UserSkillDao,
    private val userExperienceDao: UserExperienceDao,
    private val userTypeDao: UserTypeDao
) {
    fun getUserInfo(userId: Int): UserProfileResponse? {
        val user = userDao.findById(userId) ?: return null
        val educations = userEducationDao.getUserEducationsByUserId(userId)
        val educationResponses = educations
            .map { record -> record.toEducationResponse() }
            .toTypedArray()
        val skills = userSkillDao.getUserSkillsByUserId(userId)
            .map { record -> record.skill }
            .toTypedArray()
        val experiences = userExperienceDao.getUserExperiencesByUserId(userId)
            .map { record -> record.toExperience() }
            .toTypedArray()
        return UserProfileResponse(
            firstName = user.firstName,
            lastName = user.lastName,
            userType = userTypeDao.getUserTypeByd(user.userTypeId),
            companyName = userCompanyDao.findLatestByUserId(userId)?.companyName ?: "",
            degree = if (educations.isNotEmpty()) educations[0].degreeType else "",
            skills = skills,
            experiences = experiences,
            educations = educationResponses
        )
    }

    private fun UserEducationRecord.toEducationResponse(): EducationResponse {
        return EducationResponse(
            school = this.school,
            degreeType = this.degreeType,
            major = this.major
        )
    }

    private fun UserExperienceRecord.toExperience(): Experience {
        return Experience(
            title = this.jobTitle,
            company = this.company,
            startDt = getFormattedDate(this.dateStart),
            endDt = getFormattedDate(this.dateEnd),
            description = this.description
        )
    }

    private fun getFormattedDate(date: LocalDate?): String {
        return "${getMonthFromDate(date)} ${date?.year}".trim()
    }

    private fun getMonthFromDate(date: LocalDate?): String {
        val startMonth = date?.month?.name?.toLowerCase()
        return startMonth?.replaceRange(0, 1, "${startMonth[0].toUpperCase()}") ?: ""
    }
}
