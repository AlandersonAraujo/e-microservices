package br.com.emicroservices.customer.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerDTO(@NotBlank String name,
                          @NotBlank @Email String email) {
}
