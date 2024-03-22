package com.blogposts.blogpostservice.service.impl;

import com.blogposts.blogpostservice.dto.IdDto;
import com.blogposts.blogpostservice.dto.blogpost.CreateBlogpostDto;
import com.blogposts.blogpostservice.dto.blogpost.GetBlogpostDto;
import com.blogposts.blogpostservice.entity.Blogpost;
import com.blogposts.blogpostservice.exception.ResourceNotFoundException;
import com.blogposts.blogpostservice.mapper.BlogpostMapper;
import com.blogposts.blogpostservice.repository.BlogpostRepository;
import com.blogposts.blogpostservice.repository.ViewRepository;
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
    private final ViewRepository viewRepository;
    private final APIClient apiClient;
    private final BlogpostMapper blogpostMapper;

    @Autowired
    public BlogpostServiceImpl(BlogpostRepository blogpostRepository, ViewRepository viewRepository, APIClient apiClient, BlogpostMapper blogpostMapper) {
        this.blogpostRepository = blogpostRepository;
        this.viewRepository = viewRepository;
        this.apiClient = apiClient;
        this.blogpostMapper = blogpostMapper;
    }

    @Override
    public List<GetBlogpostDto> getBlogposts() {
        return this.blogpostRepository.findAll().stream().map(blogpost -> {
            this.loadViewsCount(blogpost);
            return this.blogpostMapper.toGetBlogpostResponseDto(blogpost);
        }).toList();
    }

    @Override
    public GetBlogpostDto getBlogpost(Long id) {
        Blogpost blogpost = this.blogpostRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Blogpost", id.toString()));
        return this.blogpostMapper.toGetBlogpostResponseDto(blogpost);
    }

    private void loadViewsCount(Blogpost blogpost) {
        blogpost.setViewsCount(this.viewRepository.countBlogpostViewByBlogpostId(blogpost.getId()));
    }

    @Override
    public GetBlogpostDto createBlogpost(CreateBlogpostDto createBlogpostDto) {
        log.debug("CreateBlogpostDto:" + createBlogpostDto);
        //TODO: maybe explicitly wrap in catch and log dto-s
        IdDto getUserDto = this.apiClient.getUser(createBlogpostDto.getCreatedBy().getId());
        Blogpost createBlogpost = this.blogpostMapper.fromCreateBlogpostRequestDto(createBlogpostDto);
        GetBlogpostDto getBlogpostDto = this.blogpostMapper.toGetBlogpostResponseDto(this.blogpostRepository.save(createBlogpost));
        getBlogpostDto.setCreatedBy(getUserDto);
        log.debug("GetBlogpostDto:" + getBlogpostDto);
        return getBlogpostDto;
    }

    @Override
    public void deleteUsersBlogposts(Long userId) {
        this.blogpostRepository.deleteBlogpostByCreatedBy(userId);
    }
}
