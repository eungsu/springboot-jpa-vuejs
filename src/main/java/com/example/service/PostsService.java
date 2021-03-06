package com.example.service;

import com.example.entity.posts.Posts;
import com.example.entity.posts.PostsRepository;
import com.example.exception.PostsNotFoundException;
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
    public void save(PostsSaveForm postsSaveForm) {
        postsRepository.save(postsSaveForm.toEntity());
    }

    @Transactional
    public void update(Long id, PostsUpdateForm postsUpdateForm) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new PostsNotFoundException(-4001, "해당 게시글이 없습니다."));
        posts.update(postsUpdateForm.getTitle(), postsUpdateForm.getContent());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new PostsNotFoundException(-4001, "해당 게시글이 없습니다."));
        postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public PostsDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new PostsNotFoundException(-4001, "해당 게시글이 없습니다."));
        return new PostsDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsDto> findAllDesc() {
        return postsRepository.findAllDesc();
    }

}
