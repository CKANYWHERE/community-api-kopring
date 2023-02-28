package ckanywhere.communityapi.api.auth.repository

import ckanywhere.communityapi.api.auth.entity.UserEntity
import ckanywhere.communityapi.api.auth.repository.querydsl.UserCustom
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo:JpaRepository<UserEntity, Long>, UserCustom {
}