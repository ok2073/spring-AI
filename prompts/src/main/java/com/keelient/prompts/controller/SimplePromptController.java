package com.keelient.prompts.controller;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/simple-prompt")
public class SimplePromptController {

    private final ChatClient chatClient;

    public SimplePromptController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping
    public String simple() {
        return chatClient.call(
                        new Prompt("How long has The Java Programming language been around?"))
                .getResult().getOutput().getContent();
    }
}
