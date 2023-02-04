package ckanywhere.communityapi.api.post

import ckanywhere.communityapi.api.post.dto.CreatePostDto
import ckanywhere.communityapi.api.post.entity.PostEntity
import ckanywhere.communityapi.api.post.repository.PostRepo
import org.springframework.stereotype.Service

@Service
class PostService(val postRepo: PostRepo) {

    fun getPosts(): List<PostEntity> {
        return this.postRepo.getPosts()
    }

    fun createPost(dto: CreatePostDto): PostEntity {
        return this.postRepo.save(dto.toEntity())
    }

    fun deletePost(id: Long): PostEntity? {
        return this.postRepo.deletePostByIdAndSelect(id)
    }

}