package com.emicroservices.email.presentation.dto;

import java.util.UUID;

public record EmailRecordDTO(UUID id,
                             String to,
                             String subject,
                             String body) {
}
