package com.blogposts.blogpostservice.service;

import com.blogposts.blogpostservice.dto.CreateBlogpostDto;
import com.blogposts.blogpostservice.dto.GetBlogpostDto;

import java.util.List;

public interface BlogpostService {
    List<GetBlogpostDto> getBlogposts();
    GetBlogpostDto createBlogpost(CreateBlogpostDto createBlogpostDto);
}
