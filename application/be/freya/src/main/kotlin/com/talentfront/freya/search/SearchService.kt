package com.talentfront.freya.search

import com.talentfront.freya.daos.PostingDao
import com.talentfront.freya.daos.UserDao
import com.talentfront.freya.daos.UserEducationDao
import com.talentfront.freya.daos.UserExperienceDao
import com.talentfront.freya.daos.UserSkillDao
import com.talentfront.freya.search.models.Entry
import com.talentfront.freya.search.models.Filter
import com.talentfront.freya.search.models.SearchRequest
import com.talentfront.freya.search.models.SearchResult
import org.springframework.stereotype.Component

@Component
class SearchService(
    private val userDao: UserDao,
    private val userSkillDao: UserSkillDao,
    private val userExperienceDao: UserExperienceDao,
    private val postingDao: PostingDao,
    private val userEducationDao: UserEducationDao
) {

    fun makeSearch(searchRequest: SearchRequest): SearchResult {
        val filter = determineFilter(searchRequest.filter)
        val entries = mutableListOf<Entry>()
        when (filter) {
            Filter.JOB_POSTING -> entries.searchPostings(searchRequest.searchTerm)
            Filter.TALENT -> entries.searchTalent(searchRequest.searchTerm)
            Filter.PROFESSOR -> entries.searchPostings(searchRequest.searchTerm)
            Filter.ORGANIZATION -> entries.searchPostings(searchRequest.searchTerm)
            else -> entries.searchAll(searchRequest.searchTerm)
        }
        return SearchResult(entries = entries, request = searchRequest)
    }

    fun MutableList<Entry>.searchAll(searchTerm: String?) {
        this.searchPostings(searchTerm)
        this.searchTalent(searchTerm)
    }

    fun determineFilter(filter: String?): Filter? {
        return when (filter) {
            "jobPosting" -> Filter.JOB_POSTING
            "talent" -> Filter.TALENT
            "professor" -> Filter.PROFESSOR
            "organization" -> Filter.ORGANIZATION
            else -> null
        }
    }

    fun MutableList<Entry>.searchPostings(searchTerm: String?) {
        if (searchTerm?.isNotBlank() == true) {
            postingDao.searchPostings(searchTerm)
                .forEach {
                    this.add(it.toEntry())
                }
        } else {
            postingDao.getPostings().forEach {
                this.add(it.toEntry())
            }
        }
    }

    fun MutableList<Entry>.searchTalent(searchTerm: String?) {
        val userList = mutableSetOf<Int>()
        if (searchTerm?.isNotBlank() == true) {
            userExperienceDao.searchUserExperience(searchTerm)
                .forEach {
                    if (!userList.contains(it.user?.id)) {
                        this.add(it.toEntry())
                        userList.add(it.user!!.id!!)
                    }
                }
            userSkillDao.searchUserSkills(searchTerm)
                .forEach {
                    if (!userList.contains(it.user?.id)) {
                        this.add(it.toEntry())
                        userList.add(it.user!!.id!!)
                    }
                }
            userEducationDao.getUserEducations(searchTerm)
                .forEach {
                    if (!userList.contains(it.user?.id)) {
                        this.add(it.toEntry())
                        userList.add(it.user!!.id!!)
                    }
                }
            userDao.searchUsers(searchTerm)
                .forEach {
                    if (!userList.contains(it.id)) {
                        this.add(it.toEntry())
                        userList.add(it.id!!)
                    }
                }
        } else {
            userDao.getAllUsers()
                .forEach {
                    if (!userList.contains(it.id)) {
                        this.add(it.toEntry())
                        userList.add(it.id!!)
                    }
                }
        }
    }
}
