package com.devmin.springboot.webservice.service.posts;

import com.devmin.springboot.webservice.domain.posts.Posts;
import com.devmin.springboot.webservice.domain.posts.PostsRepository;
import com.devmin.springboot.webservice.web.dto.PostsResponseDto;
import com.devmin.springboot.webservice.web.dto.PostsSaveRequestDto;
import com.devmin.springboot.webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

    @Transactional
    public Long save(PostsSaveRequestDto requstDto){
        return postsRepository.save(requstDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
}
