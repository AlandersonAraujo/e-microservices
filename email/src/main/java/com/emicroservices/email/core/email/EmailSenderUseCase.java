package com.emicroservices.email.core.email;

public interface EmailSenderUseCase {
    void send(String to, String subject, String body);
}
