package ckanywhere.communityapi.api.post.repository.querydsl.impl

import ckanywhere.communityapi.api.comment.entity.QCommentEntity
import ckanywhere.communityapi.api.post.dto.UpdatePostDto
import ckanywhere.communityapi.api.post.entity.PostEntity
import ckanywhere.communityapi.api.post.entity.QPostEntity
import ckanywhere.communityapi.api.post.repository.querydsl.PostCustom
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class PostRepoImpl(val jpaQueryFactory: JPAQueryFactory): PostCustom {
    override fun getPosts(): List<PostEntity> {
        return jpaQueryFactory
            .select(QPostEntity.postEntity)
            .from(QPostEntity.postEntity)
            .leftJoin(QPostEntity.postEntity.comments, QCommentEntity.commentEntity)
            .fetchJoin()
            .fetch()
    }

    override fun getPost(id: Long): PostEntity? {
        return jpaQueryFactory
            .select(QPostEntity.postEntity)
            .from(QPostEntity.postEntity)
            .where(QPostEntity.postEntity.id.eq(id))
            .fetchOne()
    }

    override fun deletePostByIdAndSelect(id: Long): PostEntity? {
        val post = jpaQueryFactory
            .select(QPostEntity.postEntity)
            .from(QPostEntity.postEntity)
            .where(QPostEntity.postEntity.id.eq(id))
            .fetchOne()

        jpaQueryFactory
            .delete(QPostEntity.postEntity)
            .where(QPostEntity.postEntity.id.eq(id))
            .execute()

        return post
    }

    override fun updatePost(id: Long, dto: UpdatePostDto) {
        jpaQueryFactory
            .update(QPostEntity.postEntity)
            .set(QPostEntity.postEntity.content, dto.content)
            .set(QPostEntity.postEntity.title, dto.title)
            .where(QPostEntity.postEntity.id.eq(id))
            .execute()
    }
}