package com.blogposts.userservice.rabbitmq.producer;

import com.blogposts.userservice.rabbitmq.RabbitMQEvent;
import com.blogposts.userservice.rabbitmq.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventProducerImpl implements EventProducer {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public EventProducerImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produceEvent(RabbitMQEvent event) {
        this.rabbitTemplate.convertAndSend(RabbitMQConfig.USER_EXCHANGE_NAME, event.getEventName(), event);
    }
}
