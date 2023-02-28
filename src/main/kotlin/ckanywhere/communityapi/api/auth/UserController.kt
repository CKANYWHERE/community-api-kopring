package ckanywhere.communityapi.api.auth

import ckanywhere.communityapi.api.auth.dto.RegisterDto
import ckanywhere.communityapi.api.auth.response.UserCreatedResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class UserController(val userService: UserService) {

    @PostMapping("register")
    fun createUser(@RequestBody dto: RegisterDto): UserCreatedResponse {
        return this.userService.createUser(dto)
    }

}