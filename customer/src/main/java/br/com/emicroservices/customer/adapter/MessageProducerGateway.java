package br.com.emicroservices.customer.adapter;

import br.com.emicroservices.customer.model.Customer;

public interface MessageProducerGateway {
    void produce(Customer customer);
}
