package com.emicroservices.email.application.email;

import com.emicroservices.email.adapters.email.EmailSenderGateway;
import com.emicroservices.email.core.email.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSendService(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void send(String to, String subject, String body) {
        this.emailSenderGateway.send(to, subject, body);
    }
}
