package com.blogposts.blogpostservice.rabbitmq;

import com.blogposts.blogpostservice.dto.IdDto;
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
