package com.emicroservices.email.core.queue;

import com.emicroservices.email.presentation.dto.EmailRecordDTO;

public interface MessageConsumerUseCase {
    void consume(EmailRecordDTO emailRecordDTO);
}
