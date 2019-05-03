package br.jus.tse.publicador.exchange;

import br.jus.tse.publicador.entity.Mensagem;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

@Profile({"direct"})
@Configuration
public class Direct {

    @Autowired
    private RabbitTemplate template;

    AtomicInteger dots = new AtomicInteger(0);

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        Mensagem msg = new Mensagem(10,"0600.00", "Minha descricao");

        template.setMessageConverter(new Jackson2JsonMessageConverter());
        template.convertAndSend("pje.direct.peticao", "pje.peticao", msg);

        System.out.println(" [x] Sent '" + msg.toString() + "'");
    }

}
