package com.talentfront.freya.search.models

data class SearchResult(
    val entries: List<Entry>,
    val nextPage: String? = null,
    val request: SearchRequest
)

data class Entry(
    val type: String? = null,
    val title: String? = null,
    val description: String? = null,
    val link: String? = null
)

enum class EntryType {
    USER,
    POSTING,
    COMPANY
}
