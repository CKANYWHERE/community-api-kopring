package ckanywhere.communityapi.api.post.dto

import ckanywhere.communityapi.api.post.entity.PostEntity

data class CreatePostDto(
    val content: String,
    val title: String
){
    fun toEntity(): PostEntity {
        return PostEntity(
            content = content,
            title = title
        )
    }
}
