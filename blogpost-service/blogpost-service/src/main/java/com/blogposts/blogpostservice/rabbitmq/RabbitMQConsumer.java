package com.blogposts.blogpostservice.rabbitmq;

import com.blogposts.blogpostservice.dto.GetUserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQConsumer {
    @RabbitListener(queues = {BlogpostRabbitMQConfig.USER_DELETE_QUEUE_NAME})
    public void onUserDelete(RabbitMQEvent<GetUserDto> event) {
        log.info(String.format("Event received: %s", event));
    }
}
