package com.devmin.springboot.webservice.web;

import com.devmin.springboot.webservice.service.posts.PostsService;
import com.devmin.springboot.webservice.web.dto.HelloResponseDto;
import com.devmin.springboot.webservice.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

}
