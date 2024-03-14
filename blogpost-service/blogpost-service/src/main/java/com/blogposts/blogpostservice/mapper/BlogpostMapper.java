package com.blogposts.blogpostservice.mapper;

import com.blogposts.blogpostservice.dto.CreateBlogpostDto;
import com.blogposts.blogpostservice.dto.GetBlogpostDto;
import com.blogposts.blogpostservice.entity.Blogpost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BlogpostMapper {
    BlogpostMapper MAPPER = Mappers.getMapper(BlogpostMapper.class);

    @Mapping(target = "createdBy", ignore = true)
    GetBlogpostDto toGetBlogpostResponseDto(Blogpost blogpost);

    Blogpost fromCreateBlogpostRequestDto(CreateBlogpostDto createBlogpostDto);
}
