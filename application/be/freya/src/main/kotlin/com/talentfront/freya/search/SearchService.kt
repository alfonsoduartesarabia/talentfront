package com.talentfront.freya.search

import com.talentfront.freya.config.Routes.Companion.SEARCH_PATH
import com.talentfront.freya.daos.PostingDao
import com.talentfront.freya.daos.UserDao
import com.talentfront.freya.daos.UserEducationDao
import com.talentfront.freya.search.models.Entry
import com.talentfront.freya.search.models.Filter
import com.talentfront.freya.search.models.SearchRequest
import com.talentfront.freya.search.models.SearchResult
import org.springframework.stereotype.Component

@Component
class SearchService(
    private val userDao: UserDao,
    private val postingDao: PostingDao,
    private val userEducationDao: UserEducationDao
) {
    val pageSize = 20

    fun makeSearch(searchRequest: SearchRequest, pageParam: Int?): SearchResult {
        val page = pageParam ?: 1
        val seek = (page - 1) * pageSize
        val filter = determineFilter(searchRequest.filter)
        val entries = mutableListOf<Entry>()
        when (filter) {
            Filter.JOB_POSTING -> entries.searchPostings(searchRequest.searchTerm, seek, pageSize)
            Filter.TALENT -> entries.searchTalent(searchRequest.searchTerm, seek, pageSize)
            Filter.PROFESSOR -> entries.searchPostings(searchRequest.searchTerm, seek, pageSize)
            Filter.ORGANIZATION -> entries.searchPostings(searchRequest.searchTerm, seek, pageSize)
            else -> entries.searchAll(searchRequest.searchTerm, seek, pageSize)
        }
        return SearchResult(entries = entries, request = searchRequest, nextPage = "/$SEARCH_PATH?page=${page + 1}")
    }
    fun MutableList<Entry>.searchAll(searchTerm: String?, seek: Int, limit: Int) {
        this.searchPostings(searchTerm, seek, pageSize)
        this.searchTalent(searchTerm, seek, pageSize)
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

    fun MutableList<Entry>.searchPostings(searchTerm: String?, seek: Int, limit: Int) {
        if (searchTerm?.isNotBlank() == true) {
            postingDao.searchPostings(searchTerm, seek, limit)
                .forEach {
                    this.add(it.toEntry())
                }
        } else {
            postingDao.getPostings(seek, limit).forEach {
                this.add(it.toEntry())
            }
        }
    }

    fun MutableList<Entry>.searchTalent(searchTerm: String?, seek: Int, limit: Int) {
        userEducationDao.getUserEducations(seek, limit)
            .forEach {
                this.add(it.toEntry())
            }
    }
}
