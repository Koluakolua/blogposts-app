package com.blogposts.userservice.service;

import com.blogposts.userservice.dto.CreateUserDto;
import com.blogposts.userservice.rabbitmq.producer.EventProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceImplTests {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userServiceImpl;

    @MockBean
    private EventProducer eventProducer;

    private static CreateUserDto createUser = CreateUserDto.builder()
            .login("cool_login1")
            .userSince(LocalDateTime.now())
            .build();

    @Test
    void generateEvent_whenUserDeleted() {
        Long createdUserId = this.userServiceImpl.createUser(createUser).getId();
        this.userServiceImpl.deleteUser(createdUserId);
        verify(eventProducer).produceEvent(argThat(arg ->
                arg.getEventName().equals("user.delete") && arg.getObject().getId().equals(createdUserId)
        ));
    }
}
