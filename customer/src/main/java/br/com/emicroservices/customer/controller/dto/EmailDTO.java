package br.com.emicroservices.customer.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EmailDTO {

    private UUID id;
    private String to;
    private String subject;
    private String body;
}
