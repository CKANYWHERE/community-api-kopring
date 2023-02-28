package ckanywhere.communityapi.api.auth.response

data class UserCreatedResponse(
    val userUid: Long,
    val email: String
)