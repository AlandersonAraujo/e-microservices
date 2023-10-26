package com.emicroservices.email.infrastructure.queue;

import com.emicroservices.email.adapters.email.EmailSenderGateway;
import com.emicroservices.email.adapters.queue.MessageConsumerGateway;
import com.emicroservices.email.core.email.EmailEvent;
import com.emicroservices.email.infrastructure.email.EmailEventRepository;
import com.emicroservices.email.presentation.dto.EmailRecordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AMQPMessageConsumerAdapter implements MessageConsumerGateway {

    private final EmailSenderGateway emailSenderGateway;
    private final EmailEventRepository eventRepository;

    @Autowired
    public AMQPMessageConsumerAdapter(EmailSenderGateway emailSenderGateway, EmailEventRepository eventRepository) {
        this.emailSenderGateway = emailSenderGateway;
        this.eventRepository = eventRepository;
    }

    @Override
    public void consume(EmailRecordDTO emailRecordDTO) {
        System.out.println("Save");
        eventRepository.save(new EmailEvent(emailRecordDTO.to(),
                emailRecordDTO.subject(),
                emailRecordDTO.body(),
                new Date()));

        this.emailSenderGateway.send(emailRecordDTO.to(), emailRecordDTO.subject(), emailRecordDTO.body());

    }
}
