package com.emicroservices.email.application.queue;

import com.emicroservices.email.adapters.email.EmailSenderGateway;
import com.emicroservices.email.adapters.queue.MessageConsumerGateway;
import com.emicroservices.email.core.queue.MessageConsumerUseCase;
import com.emicroservices.email.presentation.dto.EmailRecordDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumerService implements MessageConsumerUseCase {

    private final MessageConsumerGateway messageConsumerGateway;

    @Autowired
    public EmailConsumerService(MessageConsumerGateway messageConsumerGateway) {
        this.messageConsumerGateway = messageConsumerGateway;
    }

    @Override
    @RabbitListener(queues = "${broker.queue.email.name}")
    public void consume(@Payload EmailRecordDTO emailRecordDTO) {
        this.messageConsumerGateway.consume(emailRecordDTO);
    }
}
