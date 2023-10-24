package com.emicroservices.email.infrastructure.queue;

import com.emicroservices.email.adapters.queue.MessageConsumerGateway;
import com.emicroservices.email.presentation.dto.EmailRecordDTO;
import org.springframework.stereotype.Component;

@Component
public class AMQPMessageConsumerAdapter implements MessageConsumerGateway {

    @Override
    public void consume(EmailRecordDTO emailRecordDTO) {
        System.out.println("Message email: " + emailRecordDTO.to());
    }
}
