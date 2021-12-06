package com.example.web;

import com.example.dto.PostsDto;
import com.example.form.PostsSaveForm;
import com.example.form.PostsUpdateForm;
import com.example.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/posts")
public class PostsAPIController {

    private final PostsService postsService;

    @PostMapping
    public Long save(@RequestBody PostsSaveForm postsSaveForm) {
        return postsService.save(postsSaveForm);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable("id") Long id, @RequestBody PostsUpdateForm postsUpdateForm) {
        return postsService.update(id, postsUpdateForm);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable("id") Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/{id}")
    public PostsDto findById(@PathVariable("id") Long id) {
        return postsService.findById(id);
    }

    @GetMapping
    public List<PostsDto> findAll() {
        return postsService.findAllDesc();
    }

}
