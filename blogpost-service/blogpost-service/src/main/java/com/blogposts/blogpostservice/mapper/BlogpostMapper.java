package com.blogposts.blogpostservice.mapper;

import com.blogposts.blogpostservice.dto.blogpost.CreateBlogpostDto;
import com.blogposts.blogpostservice.dto.blogpost.GetBlogpostDto;
import com.blogposts.blogpostservice.entity.Blogpost;
import com.blogposts.blogpostservice.mapper.id.IdMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = IdMapper.class)
public interface BlogpostMapper {
    BlogpostMapper MAPPER = Mappers.getMapper(BlogpostMapper.class);

    //TODO: add mapping from id to object with id
    @Mapping(target = "createdBy", ignore = true)
    GetBlogpostDto toGetBlogpostResponseDto(Blogpost blogpost);

    Blogpost fromCreateBlogpostRequestDto(CreateBlogpostDto createBlogpostDto);
}
