package br.com.emicroservices.customer.core;

import br.com.emicroservices.customer.model.Customer;

public interface MessageProducerUseCase {
    void produce(Customer customer);
}
