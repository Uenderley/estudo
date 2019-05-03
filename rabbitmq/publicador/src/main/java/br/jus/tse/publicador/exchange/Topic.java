package br.jus.tse.publicador.exchange;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

@Profile({"topic"})
@Configuration
public class Topic {

    @Autowired
    private RabbitTemplate template;

    AtomicInteger dots = new AtomicInteger(0);

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        StringBuilder builder = new StringBuilder("Hello Topic");

        template.convertAndSend("pje.topic.peticao", "pje.*", builder.toString());

        System.out.println(" [x] Sent '" + builder.toString() + "'");
    }

}
