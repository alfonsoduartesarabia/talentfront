package com.talentfront.freya.search.models

data class SearchResult(
    val filter: String? = null,
    val subFilter: String? = null,
    val searchTerm: String? = null,
)
