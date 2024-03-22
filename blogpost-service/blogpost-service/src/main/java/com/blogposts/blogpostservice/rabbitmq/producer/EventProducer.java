package com.blogposts.blogpostservice.rabbitmq.producer;

import com.blogposts.blogpostservice.rabbitmq.RabbitMQEvent;

public interface EventProducer {
    void produceEvent(RabbitMQEvent event);
}
