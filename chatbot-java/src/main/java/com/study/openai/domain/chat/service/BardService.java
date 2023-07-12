package com.study.openai.domain.chat.service;

import com.study.openai.domain.chat.domain.Message;
import com.study.openai.domain.chat.domain.repository.MessageRepository;
import com.study.openai.domain.chat.presentation.dto.request.BardRequestDto;
import com.study.openai.domain.chat.presentation.dto.response.BardResponseDto;
import com.study.openai.global.config.WebClientConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BardService {
    private final MessageRepository messageRepository;

    private final WebClientConfig webClientConfig;

    @Transactional
    public BardResponseDto verification(BardRequestDto requestDto) {
        log.info(requestDto.getQuestion());
        String reply = webClientConfig.webClient()
                .post()
                .uri(uri -> uri
                        .path("/chat")
                        .queryParam("question", requestDto.getQuestion())
                        .build())
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        log.info(reply);
        log.info(requestDto.getQuestion());

        Message message = Message.builder()
                .questionMessage(requestDto.getQuestion())
                .replyMessage(reply)
                .build();

        messageRepository.save(message);

        return new BardResponseDto(reply);
    }

    @Transactional(readOnly = true)
    public List<Message> listChat() {
        return messageRepository.findAll(Sort.by(Sort.Direction.DESC, "messageId"));
    }
}
