package com.blogposts.blogpostservice.mapper;

import com.blogposts.blogpostservice.dto.view.CreateViewDto;
import com.blogposts.blogpostservice.dto.view.GetViewDto;
import com.blogposts.blogpostservice.entity.view.BlogpostView;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = IdMapper.class)
public interface ViewMapper {
    @Mapping(source = "user", target = "userId", qualifiedByName = "toId")
    BlogpostView toView(CreateViewDto createViewDto);

    @Mapping(source = "userId", target = "user", qualifiedByName = "toIdDto")
    GetViewDto toGetViewDto(BlogpostView blogpostView);
}
