package com.talentfront.freya.session

import com.talentfront.freya.daos.UserSessionDao
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SessionServiceTest {

    private val userSessionDao: UserSessionDao = mockk(relaxed = true)
    private val sessionService = SessionService(userSessionDao)

    @Test
    fun `test validate cookie`() {
        every { userSessionDao.getIsVerified(11, "259faaa3-feb9-46ea-a6b9-d9b372729f1e") } returns true
        assertEquals(11, sessionService.getValidUserIdFromCookie("11_259faaa3-feb9-46ea-a6b9-d9b372729f1e"))
    }
}
