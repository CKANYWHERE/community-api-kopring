package ckanywhere.communityapi.api.user.repository.querydsl.impl

import ckanywhere.communityapi.api.user.repository.querydsl.UserCustom
import com.querydsl.jpa.impl.JPAQueryFactory

class UserRepoImpl(val jpaQueryFactory: JPAQueryFactory): UserCustom {
}