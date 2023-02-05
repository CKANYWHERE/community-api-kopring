package ckanywhere.communityapi.api.post

import ckanywhere.communityapi.api.post.dto.CreatePostDto
import ckanywhere.communityapi.api.post.dto.UpdatePostDto
import ckanywhere.communityapi.api.post.entity.PostEntity
import ckanywhere.communityapi.api.post.repository.PostRepo
import ckanywhere.communityapi.api.post.response.PostResponse
import ckanywhere.communityapi.config.ModelMapperConfig
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(
    val postRepo: PostRepo,
    val modelMapper: ModelMapperConfig
    ) {

    fun getPosts(): List<PostResponse> {
        return this.postRepo.getPosts()
            .map { post: PostEntity -> post.toResponseDto() }
    }

    fun createPost(dto: CreatePostDto): PostResponse {
        return this.postRepo.save(dto.toEntity()).toResponseDto()
    }

    @Transactional
    fun deletePost(id: Long): PostResponse? {
        return this.postRepo.deletePostByIdAndSelect(id)?.toResponseDto()
    }

    @Transactional
    fun updatePost(id: Long, dto: UpdatePostDto): PostResponse? {
        this.postRepo.updatePost(id, dto)
        return this.postRepo.getPost(id)?.toResponseDto()
    }

}