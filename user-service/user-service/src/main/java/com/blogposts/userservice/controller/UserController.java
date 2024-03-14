package com.blogposts.userservice.controller;

import com.blogposts.userservice.dto.CreateUserDto;
import com.blogposts.userservice.dto.GetUserDto;
import com.blogposts.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<GetUserDto> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(this.userService.getUser(id), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<GetUserDto> createUser(@RequestBody @Valid CreateUserDto createUserDto) {
        GetUserDto getUserDto = this.userService.createUser(createUserDto);
        return new ResponseEntity<>(getUserDto, HttpStatus.CREATED);
    }
}
