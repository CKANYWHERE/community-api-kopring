package ckanywhere.communityapi.api.post.response

import java.time.OffsetDateTime

data class PostResponse(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: OffsetDateTime
)