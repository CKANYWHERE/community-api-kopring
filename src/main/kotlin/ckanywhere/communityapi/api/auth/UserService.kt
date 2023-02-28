package ckanywhere.communityapi.api.auth

import ckanywhere.communityapi.api.auth.dto.RegisterDto
import ckanywhere.communityapi.api.auth.repository.UserRepo
import ckanywhere.communityapi.api.auth.response.UserCreatedResponse
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(val userRepo: UserRepo) {

    fun createUser(dto: RegisterDto): UserCreatedResponse {
        val encoder = BCryptPasswordEncoder(10)
        val hashedPassword = encoder.encode(dto.password)
        return this.userRepo.save(dto.toEntityWithHash(hashedPassword))
            .toUserCreatedResponse()
    }

}