package com.blogposts.blogpostservice.rabbitmq.consumer;

import com.blogposts.blogpostservice.rabbitmq.RabbitMQConfig;
import com.blogposts.blogpostservice.rabbitmq.RabbitMQEvent;
import com.blogposts.blogpostservice.service.BlogpostService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
public class EventConsumerImpl implements EventConsumer {
    private final BlogpostService blogpostService;

    @Autowired
    public EventConsumerImpl(BlogpostService blogpostService) {
        this.blogpostService = blogpostService;
    }

    @RabbitListener(queues = {RabbitMQConfig.USER_DELETE_QUEUE_NAME})
    public void onUserDelete(RabbitMQEvent event) {
        this.blogpostService.deleteUsersBlogposts(event.getObject().getId());
    }
}
