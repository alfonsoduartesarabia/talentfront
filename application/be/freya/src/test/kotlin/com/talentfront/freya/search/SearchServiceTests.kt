package com.talentfront.freya.search

import com.talentfront.freya.daos.PostingDao
import com.talentfront.freya.daos.UserDao
import com.talentfront.freya.daos.UserEducationDao
import com.talentfront.freya.search.models.Filter
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class SearchServiceTests {
    private val userDao: UserDao = mockk(relaxed = true)
    private val postingDao: PostingDao = mockk(relaxed = true)
    private val userEducationDao: UserEducationDao = mockk(relaxed = true)
    private val searchService = SearchService(userDao, postingDao, userEducationDao)

    @Test
    fun `test determineFilter`() {
        assertEquals(Filter.JOB_POSTING, searchService.determineFilter("jobPosting"))
        assertNull(searchService.determineFilter(null))
        assertNull(searchService.determineFilter(""))
    }
}
