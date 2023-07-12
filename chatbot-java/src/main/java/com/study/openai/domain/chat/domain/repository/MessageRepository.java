package com.study.openai.domain.chat.domain.repository;

import com.study.openai.domain.chat.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
