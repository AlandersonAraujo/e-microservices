package com.emicroservices.email.infrastructure.queue;

import com.emicroservices.email.adapters.email.EmailSenderGateway;
import com.emicroservices.email.adapters.queue.MessageConsumerGateway;
import com.emicroservices.email.presentation.dto.EmailRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AMQPMessageConsumerAdapter implements MessageConsumerGateway {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public AMQPMessageConsumerAdapter(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void consume(EmailRecordDTO emailRecordDTO) {
        this.emailSenderGateway.send(emailRecordDTO.to(), emailRecordDTO.subject(), emailRecordDTO.body());
    }
}
