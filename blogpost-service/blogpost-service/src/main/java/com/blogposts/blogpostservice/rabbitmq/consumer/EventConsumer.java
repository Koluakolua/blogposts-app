package com.blogposts.blogpostservice.rabbitmq.consumer;

import com.blogposts.blogpostservice.rabbitmq.RabbitMQEvent;

public interface EventConsumer {
    void onUserDelete(RabbitMQEvent event);
}
