package com.emicroservices.email.infrastructure.email;

import com.emicroservices.email.core.email.EmailEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailEventRepository extends MongoRepository<EmailEvent, String> {
}
