package com.blogposts.blogpostservice.service.impl;

import com.blogposts.blogpostservice.dto.CreateBlogpostDto;
import com.blogposts.blogpostservice.dto.GetBlogpostDto;
import com.blogposts.blogpostservice.dto.GetUserDto;
import com.blogposts.blogpostservice.entity.Blogpost;
import com.blogposts.blogpostservice.mapper.BlogpostMapper;
import com.blogposts.blogpostservice.repository.BlogpostRepository;
import com.blogposts.blogpostservice.service.APIClient;
import com.blogposts.blogpostservice.service.BlogpostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogpostServiceImpl implements BlogpostService {
    private final BlogpostRepository blogpostRepository;
    private final APIClient apiClient;

    @Autowired
    public BlogpostServiceImpl(BlogpostRepository blogpostRepository, APIClient apiClient) {
        this.blogpostRepository = blogpostRepository;
        this.apiClient = apiClient;
    }

    @Override
    public List<GetBlogpostDto> getBlogposts() {
        return this.blogpostRepository.findAll().stream().map(BlogpostMapper.MAPPER::toGetBlogpostResponseDto).toList();
    }

    @Override
    public GetBlogpostDto createBlogpost(CreateBlogpostDto createBlogpostDto) {
        GetUserDto getUserDto = this.apiClient.getUser(createBlogpostDto.getCreatedBy());

        Blogpost createBlogpost = BlogpostMapper.MAPPER.fromCreateBlogpostRequestDto(createBlogpostDto);
        GetBlogpostDto getBlogpostDto = BlogpostMapper.MAPPER.toGetBlogpostResponseDto(this.blogpostRepository.save(createBlogpost));
        getBlogpostDto.setCreatedBy(getUserDto);
        return getBlogpostDto;
    }
}
