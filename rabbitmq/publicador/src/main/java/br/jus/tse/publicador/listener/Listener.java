package br.jus.tse.publicador.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "pje.queue.peticao")
public class Listener {

    public void receiveMessage(final Message message) {
        System.out.println("Listener");
        System.out.println(message.toString());
    }

}
