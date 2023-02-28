package ckanywhere.communityapi.api.auth.dto

import ckanywhere.communityapi.api.auth.entity.UserEntity

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