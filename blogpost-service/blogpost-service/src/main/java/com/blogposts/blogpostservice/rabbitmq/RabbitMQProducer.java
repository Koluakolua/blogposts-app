package com.blogposts.blogpostservice.rabbitmq;

import com.blogposts.blogpostservice.dto.blogpost.GetBlogpostDto;
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

    public void produceEvent(RabbitMQEvent<GetBlogpostDto> event) {
        this.rabbitTemplate.convertAndSend(BlogpostRabbitMQConfig.BLOGPOST_EXCHANGE_NAME, event.getEventName(), event);
    }
}
