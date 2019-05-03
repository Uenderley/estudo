package br.jus.tse.publicador.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class RabbitMQConfig {

    @Bean
    @Profile({"fanout"})
    Exchange newExchangeFanout() {
        return ExchangeBuilder.fanoutExchange("pje.fanout.peticao").durable(true).build();
    }

    @Bean
    @Profile({"topic"})
    Exchange newExchangeTopic() {
        return ExchangeBuilder.fanoutExchange("pje.topic.peticao").durable(true).build();
    }

    @Bean
    @Profile({"direct"})
    Exchange newExchangeDirect() {
        return ExchangeBuilder.fanoutExchange("pje.direct.peticao").durable(true).build();
    }

    @Bean
    Queue newQueueConsultaPublica() {
        return QueueBuilder.durable("pje.queue.consulta.publica").build();
    }

    @Bean
    Queue newQueueLog() {
        return QueueBuilder.durable("pje.queue.log").build();
    }

    @Bean
    Queue newQueuePeticao() {
        return QueueBuilder.durable("pje.queue.peticao").build();
    }

    @Bean
    @Profile({"fanout"})
    Binding newBindingFanoutToLogQueue() {
        return BindingBuilder.bind(newQueueLog()).to(newExchangeFanout()).with("").noargs();
    }

    @Bean
    @Profile({"fanout"})
    Binding newBindingFanoutToPeticaoQueue() {
        return BindingBuilder.bind(newQueuePeticao()).to(newExchangeFanout()).with("").noargs();
    }

    @Bean
    @Profile({"fanout"})
    Binding newBindingFanoutToConsultaPublicaQueue() {
        return BindingBuilder.bind(newQueueConsultaPublica()).to(newExchangeFanout()).with("").noargs();
    }

    @Bean
    @Profile({"topic"})
    Binding newBindingTopicToPeticaoQueue() {
        return BindingBuilder.bind(newQueuePeticao()).to(newExchangeTopic()).with("pje.peticao").noargs();
    }

    @Bean
    @Profile({"topic"})
    Binding newBindingTopicToConsultaPublicaQueue() {
        return BindingBuilder.bind(newQueueConsultaPublica()).to(newExchangeTopic()).with("pje.consulta.publica").noargs();
    }

    @Bean
    @Profile({"direct"})
    Binding newBindingDirectToPeticaoQueue() {
        return BindingBuilder.bind(newQueuePeticao()).to(newExchangeDirect()).with("pje.peticao").noargs();
    }

}
