package com.blogposts.blogpostservice.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class RabbitMQEvent<T> {
    @NonNull
    private String eventName;
    @NonNull
    private T object;
}
