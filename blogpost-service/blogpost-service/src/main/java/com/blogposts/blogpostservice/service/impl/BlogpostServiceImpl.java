package com.blogposts.blogpostservice.service.impl;

import com.blogposts.blogpostservice.dto.blogpost.CreateBlogpostDto;
import com.blogposts.blogpostservice.dto.blogpost.GetBlogpostDto;
import com.blogposts.blogpostservice.dto.GetUserDto;
import com.blogposts.blogpostservice.entity.Blogpost;
import com.blogposts.blogpostservice.mapper.BlogpostMapper;
import com.blogposts.blogpostservice.repository.BlogpostRepository;
import com.blogposts.blogpostservice.service.APIClient;
import com.blogposts.blogpostservice.service.BlogpostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BlogpostServiceImpl implements BlogpostService {
    private final BlogpostRepository blogpostRepository;
    private final APIClient apiClient;
    private final BlogpostMapper blogpostMapper;

    @Autowired
    public BlogpostServiceImpl(BlogpostRepository blogpostRepository, APIClient apiClient, BlogpostMapper blogpostMapper) {
        this.blogpostRepository = blogpostRepository;
        this.apiClient = apiClient;
        this.blogpostMapper = blogpostMapper;
    }

    @Override
    public List<GetBlogpostDto> getBlogposts() {
        return this.blogpostRepository.findAll().stream().map(this.blogpostMapper::toGetBlogpostResponseDto).toList();
    }

    @Override
    public GetBlogpostDto createBlogpost(CreateBlogpostDto createBlogpostDto) {
        log.debug("CreateBlogpostDto:" + createBlogpostDto);
        //TODO: maybe explicitly wrap in catch and log dto-s
        GetUserDto getUserDto = this.apiClient.getUser(createBlogpostDto.getCreatedBy().getId());
        Blogpost createBlogpost = this.blogpostMapper.fromCreateBlogpostRequestDto(createBlogpostDto);
        GetBlogpostDto getBlogpostDto = this.blogpostMapper.toGetBlogpostResponseDto(this.blogpostRepository.save(createBlogpost));
        getBlogpostDto.setCreatedBy(getUserDto);
        log.debug("GetBlogpostDto:" + getBlogpostDto);
        return getBlogpostDto;
    }
}
