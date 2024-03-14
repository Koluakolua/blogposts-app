package com.blogposts.userservice.mapper;

import com.blogposts.userservice.dto.CreateUserDto;
import com.blogposts.userservice.dto.GetUserDto;
import com.blogposts.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User fromCreateUserDto(CreateUserDto createUserDto);

    GetUserDto toGetUserDto(User user);
}
