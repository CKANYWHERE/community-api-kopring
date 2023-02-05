package ckanywhere.communityapi.api.comment.response

import java.time.OffsetDateTime

data class CommentResponse(
    val id: Long,
    val content: String,
    val createdAt: OffsetDateTime
)