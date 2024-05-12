package com.keelient.dadjokesai.controller;

import lombok.AllArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/dad-jokes")
@AllArgsConstructor
public class ChatController {
    private final ChatClient chatClient;

    @GetMapping
    public String generate(@RequestParam(value = "message", defaultValue = "Tell me a dad joke") String message) {
        return chatClient.call(message);
    }
}
