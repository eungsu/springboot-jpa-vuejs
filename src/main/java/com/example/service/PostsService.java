package com.example.service;

import com.example.domain.posts.Posts;
import com.example.domain.posts.PostsRepository;
import com.example.dto.PostsDto;
import com.example.form.PostsSaveForm;
import com.example.form.PostsUpdateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveForm postsSaveForm) {
        return postsRepository.save(postsSaveForm.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateForm postsUpdateForm) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        posts.update(postsUpdateForm.getTitle(), postsUpdateForm.getContent());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public PostsDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        return new PostsDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsDto> findAllDesc() {
        return postsRepository.findAllDesc();
    }

}
