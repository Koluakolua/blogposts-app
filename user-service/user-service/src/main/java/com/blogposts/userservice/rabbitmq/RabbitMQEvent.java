package com.blogposts.userservice.rabbitmq;

import com.blogposts.userservice.dto.IdDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class RabbitMQEvent {
    @NonNull
    private String eventName;
    @NonNull
    private IdDto object;
}
