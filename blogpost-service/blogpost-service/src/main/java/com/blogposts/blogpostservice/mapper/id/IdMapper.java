package com.blogposts.blogpostservice.mapper.id;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IdMapper {
    default <T> T mapId(Identifiable<T> identifiable) {
        return identifiable == null ? null : identifiable.getId();
    }

    default <T> Identifiable<T> map(T id) {
        return id == null ? ;
    }
}
