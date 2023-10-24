package br.com.emicroservices.customer.service;

import br.com.emicroservices.customer.adapter.MessageProducerGateway;
import br.com.emicroservices.customer.core.MessageProducerUseCase;
import br.com.emicroservices.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService implements MessageProducerUseCase {
    private final MessageProducerGateway messageProducerGateway;

    @Autowired
    public SendEmailService(MessageProducerGateway messageProducerGateway) {
        this.messageProducerGateway = messageProducerGateway;
    }

    @Override
    public void produce(Customer customer) {
        this.messageProducerGateway.produce(customer);
    }
}
