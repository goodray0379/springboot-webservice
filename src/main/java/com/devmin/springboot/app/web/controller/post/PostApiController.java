package com.devmin.springboot.app.web.controller.post;

import com.devmin.springboot.app.domain.post.PostService;
import com.devmin.springboot.app.web.dto.post.PostResponseDto;
import com.devmin.springboot.app.web.dto.post.PostSaveRequestDto;
import com.devmin.springboot.app.web.dto.post.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostApiController {

    private final PostService postService;

    @GetMapping("/{id}")
    public PostResponseDto findById(@PathVariable Long id)
    {
        return postService.findById(id);
    }

    @PostMapping
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long findById(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto)
    {
        return postService.update(id, requestDto);
    }
}
