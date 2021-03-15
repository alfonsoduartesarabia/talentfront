package com.talentfront.freya.search.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class SearchRequest(
    val filter: String? = null,
    val subFilter: String? = null,
    val searchTerm: String? = null,
)

enum class Filter {
    JOB_POSTING,
    TALENT,
    PROFESSOR,
    ORGANIZATION
}
