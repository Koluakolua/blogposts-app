package com.blogposts.blogpostservice.mapper;

import com.blogposts.blogpostservice.dto.blogpost.CreateBlogpostDto;
import com.blogposts.blogpostservice.dto.blogpost.GetBlogpostDto;
import com.blogposts.blogpostservice.entity.Blogpost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = { IdMapper.class, ReactionMapper.class })
public interface BlogpostMapper {
    @Mapping(target = "createdBy", qualifiedByName = "toIdDto")
    GetBlogpostDto toGetBlogpostResponseDto(Blogpost blogpost);

    @Mapping(target = "createdBy", qualifiedByName = "toId")
    Blogpost fromCreateBlogpostRequestDto(CreateBlogpostDto createBlogpostDto);

//    //TODO: how to get rid of this duplication
//    @Named("toGetUserDto")
//    default GetUserDto toGetUserDto(Long id) {
//        if (id == null) {
//            return null;
//        }
//        GetUserDto getUserDto = new GetUserDto();
//        getUserDto.setId(id);
//        return getUserDto;
//    }
}
