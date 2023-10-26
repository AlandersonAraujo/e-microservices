package com.emicroservices.email.core.email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Document(collection = "email_events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailEvent {
    @MongoId
    private String id;
    private String to;
    private String subject;
    private String body;
    private Date timestamp;

    public EmailEvent(String to, String subject, String body, Date timestamp) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.timestamp = timestamp;
    }
}
