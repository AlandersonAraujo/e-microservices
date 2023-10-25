package com.emicroservices.email.infrastructure.email;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.emicroservices.email.adapters.email.EmailSenderGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Value("${ses.emailsource}")
    private String emailSource;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void send(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource(emailSource)
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withHtml(new Content(body)))
                );

        try {
            this.amazonSimpleEmailService.sendEmail(request);
        } catch (AmazonClientException exception) {
            System.out.println("Error: " + exception);
        }
    }
}
