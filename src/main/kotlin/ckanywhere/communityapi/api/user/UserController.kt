package ckanywhere.communityapi.api.user

import ckanywhere.communityapi.api.user.dto.RegisterDto
import ckanywhere.communityapi.api.user.response.UserCreatedResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody dto: RegisterDto): UserCreatedResponse {
        return this.userService.createUser(dto)
    }

}