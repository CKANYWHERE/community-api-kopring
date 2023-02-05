package ckanywhere.communityapi.api.post.response

import ckanywhere.communityapi.api.comment.entity.CommentEntity
import ckanywhere.communityapi.api.comment.response.CommentResponse
import java.time.OffsetDateTime

data class PostResponse(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: OffsetDateTime
)

data class PostResponseWithComment(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: OffsetDateTime,
    val comments: List<CommentResponse>
)