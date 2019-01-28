package com.example.rabbitlistener;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfiguration {

    @Bean
    Exchange exampleExchange() {
        return new TopicExchange("exTopicExchange");
    }

    @Bean
    Exchange exampleSecondExchange() {
        return ExchangeBuilder.directExchange("exampleDirectExchange").autoDelete().internal().build();
    }

    @Bean
    Exchange newExchange() {
        return ExchangeBuilder.topicExchange("exampleTopicExchange").autoDelete().durable(true).internal().build();
    }

    @Bean
    Exchange fanoutExchange() {
        return ExchangeBuilder.fanoutExchange("exampleFanoutExchange").autoDelete().durable(true).internal().build();
    }

    @Bean
    Exchange headersExchange() {
        return ExchangeBuilder.headersExchange("exampleHeadersExchange").autoDelete().durable(true).internal().build();
    }
}
