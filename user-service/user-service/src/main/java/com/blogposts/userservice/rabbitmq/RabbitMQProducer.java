package com.blogposts.userservice.rabbitmq;

import com.blogposts.userservice.dto.GetUserDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produceEvent(RabbitMQEvent<GetUserDto> event) {
        this.rabbitTemplate.convertAndSend(UserRabbitMQConfig.USER_EXCHANGE_NAME, event.getEventName(), event);
    }
}
