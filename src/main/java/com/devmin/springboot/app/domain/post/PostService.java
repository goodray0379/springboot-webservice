package com.devmin.springboot.app.domain.post;

import com.devmin.springboot.app.web.dto.post.PostResponseDto;
import com.devmin.springboot.app.web.dto.post.PostSaveRequestDto;
import com.devmin.springboot.app.web.dto.post.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public PostResponseDto findById(Long id){
        Post entity = postRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
        return new PostResponseDto(entity);
    }

    @Transactional
    public Long save(PostSaveRequestDto requestDto){
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto){
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
        post.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
}
