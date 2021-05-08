package com.talentfront.freya.session

import com.talentfront.freya.daos.UserSessionDao
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.text.NumberFormat
import java.time.LocalDateTime

class SessionServiceTest {

    private val userSessionDao: UserSessionDao = mockk(relaxed = true)
    private val sessionService = SessionService(userSessionDao)

    @Test
    fun `test validate cookie`() {
        every { userSessionDao.getIsVerified(11, "259faaa3-feb9-46ea-a6b9-d9b372729f1e") } returns true
        assertEquals(11, sessionService.getValidUserIdFromCookie("11_259faaa3-feb9-46ea-a6b9-d9b372729f1e"))
    }

    @Test
    fun `test number format`() {
        val hi = 10_000
        val format = NumberFormat.getCompactNumberInstance()
        println(format.format(hi))
        val localDateTime = LocalDateTime.now()
        println("${localDateTime.month.name.camelCase()} ${localDateTime.dayOfMonth}, ${localDateTime.year}")
    }

    private fun String.camelCase(): String {
        val lowerCase = this.toLowerCase()
        return lowerCase.replaceRange(0, 1, "${lowerCase[0].toUpperCase()}")
    }
}
