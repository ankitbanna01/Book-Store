package com.ankit.bookstore.order.config;

import com.ankit.bookstore.order.ApplicationProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ApplicationProperties.class)
public class RabbitMQConfig {

    private final ApplicationProperties properties;

    public RabbitMQConfig(ApplicationProperties properties) {
        this.properties = properties;
    }

    // RabbitAdmin for auto-declaration
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin admin = new RabbitAdmin(connectionFactory);
        admin.setAutoStartup(true);
        return admin;
    }

    // Exchange declaration
    @Bean
    public DirectExchange exchange(RabbitAdmin admin) {
        DirectExchange ex = new DirectExchange(properties.orderEventsExchange());
        admin.declareExchange(ex);
        return ex;
    }

    // Queues
    @Bean
    public Queue newOrdersQueue(RabbitAdmin admin) {
        Queue q = QueueBuilder.durable(properties.newOrdersQueue()).build();
        admin.declareQueue(q);
        return q;
    }

    @Bean
    public Queue deliveredOrdersQueue(RabbitAdmin admin) {
        Queue q = QueueBuilder.durable(properties.deliveredOrdersQueue()).build();
        admin.declareQueue(q);
        return q;
    }

    @Bean
    public Queue cancelledOrdersQueue(RabbitAdmin admin) {
        Queue q = QueueBuilder.durable(properties.cancelledOrdersQueue()).build();
        admin.declareQueue(q);
        return q;
    }

    @Bean
    public Queue errorOrdersQueue(RabbitAdmin admin) {
        Queue q = QueueBuilder.durable(properties.errorOrdersQueue()).build();
        admin.declareQueue(q);
        return q;
    }

    // Bindings
    @Bean
    public Binding newOrdersQueueBinding(RabbitAdmin admin, Queue newOrdersQueue, DirectExchange exchange) {
        Binding binding = BindingBuilder.bind(newOrdersQueue).to(exchange).with(properties.newOrdersQueue());
        admin.declareBinding(binding);
        return binding;
    }

    @Bean
    public Binding deliveredOrdersQueueBinding(RabbitAdmin admin, Queue deliveredOrdersQueue, DirectExchange exchange) {
        Binding binding =
                BindingBuilder.bind(deliveredOrdersQueue).to(exchange).with(properties.deliveredOrdersQueue());
        admin.declareBinding(binding);
        return binding;
    }

    @Bean
    public Binding cancelledOrdersQueueBinding(RabbitAdmin admin, Queue cancelledOrdersQueue, DirectExchange exchange) {
        Binding binding =
                BindingBuilder.bind(cancelledOrdersQueue).to(exchange).with(properties.cancelledOrdersQueue());
        admin.declareBinding(binding);
        return binding;
    }

    @Bean
    public Binding errorOrdersQueueBinding(RabbitAdmin admin, Queue errorOrdersQueue, DirectExchange exchange) {
        Binding binding = BindingBuilder.bind(errorOrdersQueue).to(exchange).with(properties.errorOrdersQueue());
        admin.declareBinding(binding);
        return binding;
    }

    // RabbitTemplate
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, ObjectMapper objectMapper) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jacksonConverter(objectMapper));
        return template;
    }

    @Bean
    public Jackson2JsonMessageConverter jacksonConverter(ObjectMapper mapper) {
        return new Jackson2JsonMessageConverter(mapper);
    }
}
