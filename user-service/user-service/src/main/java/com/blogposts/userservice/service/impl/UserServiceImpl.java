package com.blogposts.userservice.service.impl;

import com.blogposts.userservice.dto.CreateUserDto;
import com.blogposts.userservice.dto.GetUserDto;
import com.blogposts.userservice.dto.IdDto;
import com.blogposts.userservice.entity.User;
import com.blogposts.userservice.exception.ResourceNotFoundException;
import com.blogposts.userservice.mapper.UserMapper;
import com.blogposts.userservice.rabbitmq.RabbitMQEvent;
import com.blogposts.userservice.rabbitmq.producer.EventProducer;
import com.blogposts.userservice.repository.UserRepository;
import com.blogposts.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final String resourceName = "User";
    private final UserRepository userRepository;

    private final EventProducer eventProducer;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EventProducer eventProducer) {
        this.userRepository = userRepository;
        this.eventProducer = eventProducer;
    }

    @Override
    public GetUserDto getUser(Long id) {
        return UserMapper.MAPPER.toGetUserDto(this.userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(resourceName, id.toString())
        ));
    }

    @Override
    public GetUserDto createUser(CreateUserDto createUserDto) {
        User user = UserMapper.MAPPER.fromCreateUserDto(createUserDto);
        return UserMapper.MAPPER.toGetUserDto(this.userRepository.save(user));
    }

    @Override
    public Long deleteUser(Long id) {
        this.userRepository.deleteById(id);
        this.eventProducer.produceEvent(new RabbitMQEvent(
                "user.delete",
                new IdDto(id)
        ));
        return id;
    }
}
