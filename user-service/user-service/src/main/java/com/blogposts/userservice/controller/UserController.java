package com.blogposts.userservice.controller;

import com.blogposts.userservice.dto.CreateUserDto;
import com.blogposts.userservice.dto.GetUserDto;
import com.blogposts.userservice.rabbitmq.RabbitMQEvent;
import com.blogposts.userservice.rabbitmq.RabbitMQProducer;
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
    private final RabbitMQProducer rabbitMQProducer;

    @Autowired
    public UserController(UserService userService, RabbitMQProducer rabbitMQProducer) {
        this.userService = userService;
        this.rabbitMQProducer = rabbitMQProducer;
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

    @PostMapping("test/{msg}")
    public ResponseEntity<?> test(@PathVariable String msg) {
        GetUserDto user = new GetUserDto();
        user.setId(777L);
        this.rabbitMQProducer.produceEvent(new RabbitMQEvent<>("user.delete", user));
        return ResponseEntity.ok().build();
    }
}
