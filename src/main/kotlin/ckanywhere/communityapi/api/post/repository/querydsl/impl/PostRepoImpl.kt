package ckanywhere.communityapi.api.post.repository.querydsl.impl

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
            .from(QPostEntity.postEntity).fetch();
    }

    override fun deletePostByIdAndSelect(id: Long): PostEntity? {
        jpaQueryFactory
            .delete(QPostEntity.postEntity)
            .where(QPostEntity.postEntity.id.eq(id))
            .execute()

        return jpaQueryFactory
            .select(QPostEntity.postEntity)
            .from(QPostEntity.postEntity)
            .where(QPostEntity.postEntity.id.eq(id))
            .fetchOne()
    }
}