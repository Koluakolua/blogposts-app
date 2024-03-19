package com.blogposts.blogpostservice.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlogpostRabbitMQConfig {
    public static final String BLOGPOST_EXCHANGE_NAME = "blogpost.exchange";
    public static final String USER_DELETE_QUEUE_NAME = "user.delete.queue";

    @Bean
    public TopicExchange blogpostExchange() {
        return new TopicExchange(BLOGPOST_EXCHANGE_NAME);
    }

    //TODO: make a centralized exchange config with event names and interfaces
    @Bean
    public TopicExchange userExchange() {
        return new TopicExchange("user.exchange");
    }

    @Bean
    public Queue userDeleteQueue() {
        return new Queue(USER_DELETE_QUEUE_NAME);
    }

    @Bean
    public Binding userDeleteQueueBinding() {
        return BindingBuilder
                .bind(userDeleteQueue())
                .to(userExchange())
                .with("user.delete");
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
