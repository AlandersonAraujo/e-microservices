package com.emicroservices.email.adapters.queue;

import com.emicroservices.email.presentation.dto.EmailRecordDTO;

public interface MessageConsumerGateway {
    void consume(EmailRecordDTO emailRecordDTO);
}
