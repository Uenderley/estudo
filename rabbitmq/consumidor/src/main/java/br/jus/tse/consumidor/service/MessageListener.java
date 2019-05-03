package br.jus.tse.consumidor.service;

import br.jus.tse.consumidor.entity.Mensagem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);

    @RabbitListener(queues = "pje.queue.peticao")
    public void consumidor(Mensagem mensagem){
        log.info("Received message: {} from app1 queue.", mensagem.toString());
    }


}
