package com.example.web;

import com.example.dto.PostsDto;
import com.example.form.PostsSaveForm;
import com.example.form.PostsUpdateForm;
import com.example.model.response.ListResponseData;
import com.example.model.response.ResponseData;
import com.example.model.response.ResponseService;
import com.example.model.response.SingleResponseData;
import com.example.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/posts")
public class PostsAPIController {

    private final PostsService postsService;
    private final ResponseService responseService;

    @PostMapping
    public ResponseData save(@RequestBody PostsSaveForm postsSaveForm) {
       postsService.save(postsSaveForm);
       return responseService.getSuccessResponse();
    }

    @PutMapping("/{id}")
    public ResponseData update(@PathVariable("id") Long id, @RequestBody PostsUpdateForm postsUpdateForm) {
        postsService.update(id, postsUpdateForm);
        return responseService.getSuccessResponse();
    }

    @DeleteMapping("/{id}")
    public ResponseData delete(@PathVariable("id") Long id) {
        postsService.delete(id);
        return responseService.getSuccessResponse();
    }

    @GetMapping("/{id}")
    public SingleResponseData<PostsDto> findById(@PathVariable("id") Long id) {
        return responseService.getResponseData(postsService.findById(id));
    }

    @GetMapping
    public ListResponseData<PostsDto> findAll() {
        return responseService.getResponseData(postsService.findAllDesc());
    }

}
