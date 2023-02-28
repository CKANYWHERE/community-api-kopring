package ckanywhere.communityapi.api.auth.repository.querydsl.impl

import ckanywhere.communityapi.api.auth.repository.querydsl.UserCustom
import com.querydsl.jpa.impl.JPAQueryFactory

class UserRepoImpl(val jpaQueryFactory: JPAQueryFactory): UserCustom {
}