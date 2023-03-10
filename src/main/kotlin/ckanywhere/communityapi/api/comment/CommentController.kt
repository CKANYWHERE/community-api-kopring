package ckanywhere.communityapi.api.comment

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/comment")
class CommentController {

    @GetMapping(produces = ["application/json"])
    fun getComments(): String {
        return "getComments"
    }
}