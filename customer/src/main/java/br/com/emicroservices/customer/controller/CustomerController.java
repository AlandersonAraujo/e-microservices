package br.com.emicroservices.customer.controller;

import br.com.emicroservices.customer.controller.dto.CustomerDTO;
import br.com.emicroservices.customer.model.Customer;
import br.com.emicroservices.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody @Valid CustomerDTO customerDTO) {
        Customer newCustomer = new Customer();
        BeanUtils.copyProperties(customerDTO, newCustomer);

        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(newCustomer));
    }
}
