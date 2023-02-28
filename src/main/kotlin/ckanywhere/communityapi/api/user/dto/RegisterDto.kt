package ckanywhere.communityapi.api.user.dto

import ckanywhere.communityapi.api.post.entity.PostEntity
import ckanywhere.communityapi.api.user.entity.UserEntity

data class RegisterDto(
    val email: String,
    val password: String
){
    fun toEntity(): UserEntity {
        return UserEntity(
            email = email,
            password = password
        )
    }

    fun toEntityWithHash(hashedPassword: String): UserEntity {
        return UserEntity(
            email = email,
            password = hashedPassword
        )
    }
}