package com.blogposts.userservice.service;

import com.blogposts.userservice.dto.CreateUserDto;
import com.blogposts.userservice.dto.GetUserDto;

public interface UserService {
    GetUserDto getUser(Long id);
    GetUserDto createUser(CreateUserDto createUserDto);

    Long deleteUser(Long id);
}
