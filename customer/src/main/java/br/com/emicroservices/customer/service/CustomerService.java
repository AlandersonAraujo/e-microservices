package br.com.emicroservices.customer.service;

import br.com.emicroservices.customer.model.Customer;
import br.com.emicroservices.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final SendEmailService sendEmailService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, SendEmailService sendEmailService) {
        this.customerRepository = customerRepository;
        this.sendEmailService = sendEmailService;
    }

    @Transactional
    public Customer save(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        sendEmailService.produce(customer);
        return newCustomer;
    }
}
