package com.example.rabbitpublisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class RabbitpublisherApplication implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RabbitpublisherApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleMessage sp = new SimpleMessage("FirstMessage", "SimpleDescription");
        rabbitTemplate.convertAndSend("poc-direct", "queue-key-2", sp);

        rabbitTemplate.convertAndSend("poc-direct", "queue-1", "Hello from queue-1" + new Date());
        rabbitTemplate.convertAndSend("poc-direct", "queue-key-2", "Hello from queue-2" + new Date());
        rabbitTemplate.convertAndSend("poc-fanout", "nada", "Hello from queue-3" + new Date());


        SimpleMessage simpleMessage = new SimpleMessage("FirstMessage", "SimpleDescription");
        rabbitTemplate.convertAndSend("myTopicExchange", "topic", simpleMessage);

    }
}


