package ckanywhere.communityapi.api.user.response

data class UserCreatedResponse(
    val userUid: Long,
    val email: String
)