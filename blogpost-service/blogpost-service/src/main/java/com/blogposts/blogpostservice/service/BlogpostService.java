package com.blogposts.blogpostservice.service;

import com.blogposts.blogpostservice.dto.blogpost.CreateBlogpostDto;
import com.blogposts.blogpostservice.dto.blogpost.GetBlogpostDto;

import java.util.List;

public interface BlogpostService {
    List<GetBlogpostDto> getBlogposts();
    GetBlogpostDto createBlogpost(CreateBlogpostDto createBlogpostDto);
}
