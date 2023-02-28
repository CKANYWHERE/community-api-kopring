package ckanywhere.communityapi.api.user.entity

import ckanywhere.communityapi.api.user.response.UserCreatedResponse
import javax.persistence.*

@Entity
@Table(name = "user")
class UserEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_uid")
    var uid: Long = 0L,

    @Column(name = "email", length = 100)
    var email: String = "",

    @Column(name = "password", length = 1000)
    var password: String = ""
    ){
    fun toUserCreatedResponse(): UserCreatedResponse {
        return UserCreatedResponse(
            userUid = uid,
            email = email
        )
    }
}