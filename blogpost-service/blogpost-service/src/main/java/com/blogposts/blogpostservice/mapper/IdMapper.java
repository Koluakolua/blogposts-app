package com.blogposts.blogpostservice.mapper;

import com.blogposts.blogpostservice.dto.IdDto;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface IdMapper {
    @Named("toId")
    default Long toId(IdDto idDto) {
        return idDto == null ? null : idDto.getId();
    }

    @Named("toIdDto")
    default IdDto toIdDto(Long id) {
        return id == null ? null : new IdDto(id);
    }
}
