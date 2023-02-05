package ckanywhere.communityapi.api.comment.entity

import ckanywhere.communityapi.api.post.entity.PostEntity
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table(name = "comment")
class CommentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column(name = "content", length = 200)
    var content: String,

    @Column(name = "created_at")
    var createdAt: OffsetDateTime = OffsetDateTime.now(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "post_id",
        foreignKey = ForeignKey(name = "fk_post_id"),
        nullable = true
    )
    var comments: PostEntity? = null
) {

}