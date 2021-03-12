package com.devmin.springboot.webservice.web;

import com.devmin.springboot.webservice.service.posts.PostsService;
import com.devmin.springboot.webservice.web.dto.HelloResponseDto;
import com.devmin.springboot.webservice.web.dto.PostsResponseDto;
import com.devmin.springboot.webservice.web.dto.PostsSaveRequestDto;
import com.devmin.springboot.webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id)
    {
        return postsService.findById(id);
    }

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long findById(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto)
    {
        return postsService.update(id, requestDto);
    }
}
