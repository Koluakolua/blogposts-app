package com.blogposts.userservice.rabbitmq.producer;

import com.blogposts.userservice.rabbitmq.RabbitMQEvent;

public interface EventProducer {
    void produceEvent(RabbitMQEvent event);
}
