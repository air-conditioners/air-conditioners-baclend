package com.study.openai.domain.chat.presentation;

import com.study.openai.domain.chat.domain.Message;
import com.study.openai.domain.chat.presentation.dto.request.BardRequestDto;
import com.study.openai.domain.chat.presentation.dto.response.BardResponseDto;
import com.study.openai.domain.chat.service.BardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class BardController {
    private final BardService bardService;

    @PostMapping("/question")
    private BardResponseDto getChatGpt(@RequestBody BardRequestDto requestDto){
        return bardService.verification(requestDto);
    }

    @GetMapping("/read")
    public List<Message> listMessage() {
        return bardService.listChat();
    }
}
