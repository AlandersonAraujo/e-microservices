package com.emicroservices.email.adapters.email;

public interface EmailSenderGateway {
    void send(String to, String subject, String body);
}
