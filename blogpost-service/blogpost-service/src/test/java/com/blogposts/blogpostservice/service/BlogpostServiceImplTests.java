package com.blogposts.blogpostservice.service;

import com.blogposts.blogpostservice.dto.IdDto;
import com.blogposts.blogpostservice.dto.blogpost.CreateBlogpostDto;
import com.blogposts.blogpostservice.exception.ResourceNotFoundException;
import com.blogposts.blogpostservice.rabbitmq.consumer.EventConsumer;
import com.blogposts.blogpostservice.rabbitmq.RabbitMQEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class BlogpostServiceImplTests {
    @Autowired
    @Qualifier("blogpostServiceImpl")
    private BlogpostService blogpostServiceImpl;

    @Autowired
    private EventConsumer eventConsumer; //not very good without interface

    @MockBean
    private APIClient apiClient;

    public static final Long userId = 101L;
    private static final CreateBlogpostDto createBlogpostDto = new CreateBlogpostDto(
            "cool tweet bla bla 1",
            LocalDateTime.now(),
            new IdDto(userId)
    );


    @BeforeEach
    void setup() {
        when(apiClient.getUser(eq(userId))).thenReturn(new IdDto(userId));
    }

    @Test
    @Disabled("Need to mock rabbit consumer")
    void deleteBlogposts_whenUserDeleteEvent() {
        this.blogpostServiceImpl.createBlogpost(createBlogpostDto);
        this.eventConsumer.onUserDelete(new RabbitMQEvent("user.delete", new IdDto(userId)));
        assertThrows(ResourceNotFoundException.class, () -> {
            this.blogpostServiceImpl.getBlogpost(userId);
        });
    }
}
