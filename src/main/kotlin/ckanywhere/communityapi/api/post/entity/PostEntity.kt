package ckanywhere.communityapi.api.post.entity

import java.time.OffsetDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "post")
class PostEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,

    @Column(name = "title", length = 100)
    var title: String,

    @Column(name = "content", columnDefinition = "TEXT")
    var content: String,

    @Column(name = "created_at")
    var createdAt: OffsetDateTime = OffsetDateTime.now(),
    ) {

    constructor(content: String, title: String) : this(content = "", title = "", id = 0) {
        this.title = title
        this.content = content
    }

}