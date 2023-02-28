package ckanywhere.communityapi.api.user

import ckanywhere.communityapi.api.user.dto.RegisterDto
import ckanywhere.communityapi.api.user.entity.UserEntity
import ckanywhere.communityapi.api.user.repository.UserRepo
import ckanywhere.communityapi.api.user.response.UserCreatedResponse
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class UserService(val userRepo: UserRepo) {

    fun createUser(dto: RegisterDto): UserCreatedResponse {
        val encoder = BCryptPasswordEncoder(10)
        val hashedPassword = encoder.encode(dto.password)
        return this.userRepo.save(dto.toEntityWithHash(hashedPassword))
            .toUserCreatedResponse()
    }

}