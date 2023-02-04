package ckanywhere.communityapi.api.post.repository

import ckanywhere.communityapi.api.post.entity.PostEntity
import ckanywhere.communityapi.api.post.repository.querydsl.PostCustom
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepo:JpaRepository<PostEntity, Long>, PostCustom {
}