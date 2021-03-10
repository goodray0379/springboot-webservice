package com.devmin.springboot.webservice.service.posts;

import com.devmin.springboot.webservice.domain.posts.PostsRepository;
import com.devmin.springboot.webservice.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requstDto){
        return postsRepository.save(requstDto.toEntity()).getId();
    }
}
