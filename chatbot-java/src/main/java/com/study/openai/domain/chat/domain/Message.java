package com.study.openai.domain.chat.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "message_table")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Message {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @Column(columnDefinition = "TEXT")
    private String replyMessage;

    @Column(columnDefinition = "TEXT")
    private String questionMessage;


    @Builder
    public Message(String questionMessage, String replyMessage) {
        this.questionMessage = questionMessage;
        this.replyMessage = replyMessage;
    }
}
