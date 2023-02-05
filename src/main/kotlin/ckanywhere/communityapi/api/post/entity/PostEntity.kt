package ckanywhere.communityapi.api.post.entity

import ckanywhere.communityapi.api.comment.entity.CommentEntity
import ckanywhere.communityapi.api.post.response.PostResponse
import ckanywhere.communityapi.api.post.response.PostResponseWithComment
import java.time.OffsetDateTime
import javax.persistence.*
import javax.xml.stream.events.Comment

@Entity
@Table(name = "post")
class PostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0L,

    @Column(name = "title", length = 100)
    var title: String = "",

    @Column(name = "content", columnDefinition = "TEXT")
    var content: String = "",

    @Column(name = "created_at")
    var createdAt: OffsetDateTime = OffsetDateTime.now(),

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comment")
    var comments: MutableList<CommentEntity> = mutableListOf()
    ) {

    fun toResponseDto(): PostResponse {
        return PostResponse(
            id = id,
            title = title,
            content = content,
            createdAt = createdAt
        )
    }

    fun toResponseWithComment(): PostResponseWithComment {
        return PostResponseWithComment(
            id = id,
            title = title,
            content = content,
            createdAt = createdAt,
            comments = comments.map { comment: CommentEntity -> comment.toResponse() }
        )
    }

}