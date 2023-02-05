package ckanywhere.communityapi.api.post

import ckanywhere.communityapi.api.post.dto.CreatePostDto
import ckanywhere.communityapi.api.post.dto.UpdatePostDto
import ckanywhere.communityapi.api.post.entity.PostEntity
import ckanywhere.communityapi.api.post.repository.PostRepo
import ckanywhere.communityapi.config.ModelMapperConfig
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostService(
    val postRepo: PostRepo,
    val modelMapper: ModelMapperConfig
    ) {

    fun getPosts(): List<PostEntity> {
        return this.postRepo.getPosts()
    }

    fun createPost(dto: CreatePostDto): PostEntity {
        return this.postRepo.save(dto.toEntity())
    }

    @Transactional
    fun deletePost(id: Long): PostEntity? {
        return this.postRepo.deletePostByIdAndSelect(id)
    }

    @Transactional
    fun updatePost(id: Long, dto: UpdatePostDto): PostEntity? {
        this.postRepo.updatePost(id, dto)
        return this.postRepo.getPost(id)
    }

}