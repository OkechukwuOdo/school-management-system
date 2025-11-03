package com.justintime.schoolmanagement.entity.portal;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("messages")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    private String id;
    private String senderId;
    private String receiverId;
    private String content;
    private LocalDateTime sentAt;
}
