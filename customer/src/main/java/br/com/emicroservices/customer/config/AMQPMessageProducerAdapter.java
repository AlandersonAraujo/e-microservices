package br.com.emicroservices.customer.config;

import br.com.emicroservices.customer.adapter.MessageProducerGateway;
import br.com.emicroservices.customer.controller.dto.EmailDTO;
import br.com.emicroservices.customer.model.Customer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AMQPMessageProducerAdapter implements MessageProducerGateway {

    private final RabbitTemplate rabbitTemplate;

    public AMQPMessageProducerAdapter(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    @Override
    public void produce(Customer customer) {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setId(customer.getId());
        emailDTO.setTo(customer.getEmail());
        emailDTO.setSubject("Registration completed successfully");
        emailDTO.setBody(customer.getName() + ", Welcome!\nThank you for your registration. Enjoy all the features of our platform now!");

        rabbitTemplate.convertAndSend("", routingKey, emailDTO);
    }
}
