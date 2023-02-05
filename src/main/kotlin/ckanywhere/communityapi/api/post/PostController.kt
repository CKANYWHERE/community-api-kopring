package ckanywhere.communityapi.api.post

import ckanywhere.communityapi.api.post.dto.CreatePostDto
import ckanywhere.communityapi.api.post.dto.UpdatePostDto
import ckanywhere.communityapi.api.post.entity.PostEntity
import ckanywhere.communityapi.api.post.response.PostResponse
import ckanywhere.communityapi.api.post.response.PostResponseWithComment
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/post")
class PostController(val postService: PostService) {

    @GetMapping(produces = ["application/json"])
    fun getPosts(): List<PostResponseWithComment> {
        return this.postService.getPosts()
    }

    @PostMapping
    fun createPost(@RequestBody dto: CreatePostDto): PostResponse {
        return this.postService.createPost(dto)
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): PostResponse? {
        return this.postService.deletePost(id)
    }

    @PutMapping("/{id}")
    fun updatePost(
        @PathVariable id: Long,
        @RequestBody dto: UpdatePostDto
    ): PostResponse? {
        return this.postService.updatePost(id, dto)
    }
}