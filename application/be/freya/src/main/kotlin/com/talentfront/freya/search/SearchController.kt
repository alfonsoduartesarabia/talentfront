package com.talentfront.freya.search

import com.talentfront.freya.config.Routes.Companion.SEARCH_PATH
import com.talentfront.freya.search.models.SearchRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SearchController(
    val searchService: SearchService
) {

    @PostMapping(value = [SEARCH_PATH])
    fun search(@RequestBody searchRequest: SearchRequest, @RequestParam page: Int?): ResponseEntity<*> {
        return try {
            ResponseEntity.ok(searchService.makeSearch(searchRequest, page))
        } catch (e: Exception) {
            ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST)
        }
    }
}
