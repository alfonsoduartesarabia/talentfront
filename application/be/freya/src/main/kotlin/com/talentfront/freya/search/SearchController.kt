package com.talentfront.freya.search

import com.talentfront.freya.daos.UserDao
import com.talentfront.freya.models.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SearchController(
    val userDao: UserDao
) {

    /**
     * This is just a first test endpoint to test CRUD functionality with the database
     */

    @GetMapping(value = ["search"])
    fun searchGiphy(): ResponseEntity<*> {
        return try {
            userDao.saveUser(User(null, "some@eemail.com", "SBSLBHLHSBS", "SFHLSDHFHS", 1, "bob", "jilliams"))
            ResponseEntity.ok("Hey Wassup")
        } catch (e: Exception) {
            ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST)
        }
    }
}
