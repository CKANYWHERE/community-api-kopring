package ckanywhere.communityapi.api.user.repository

import ckanywhere.communityapi.api.user.entity.UserEntity
import ckanywhere.communityapi.api.user.repository.querydsl.UserCustom
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo:JpaRepository<UserEntity, Long>, UserCustom {
}