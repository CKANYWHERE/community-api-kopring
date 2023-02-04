package ckanywhere.communityapi.api.post.repository.querydsl

import ckanywhere.communityapi.api.post.dto.UpdatePostDto
import ckanywhere.communityapi.api.post.entity.PostEntity

interface PostCustom {
    fun getPosts(): List<PostEntity>

    fun getPost(id: Long): PostEntity?

    fun deletePostByIdAndSelect(id: Long): PostEntity?
    fun updatePost(id: Long, dto: UpdatePostDto)
}