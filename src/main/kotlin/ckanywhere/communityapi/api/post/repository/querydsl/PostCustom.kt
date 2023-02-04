package ckanywhere.communityapi.api.post.repository.querydsl

import ckanywhere.communityapi.api.post.entity.PostEntity

interface PostCustom {
    fun getPosts(): List<PostEntity>
    fun deletePostByIdAndSelect(id: Long): PostEntity?
}