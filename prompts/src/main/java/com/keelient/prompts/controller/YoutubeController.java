package com.keelient.prompts.controller;


import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/youtube")
public class YoutubeController {

    private final ChatClient chatClient;

    @Value("classpath:/prompts/youtube.st")
    private Resource ytPromptResource;

    public YoutubeController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/popular-step-one")
    public String findPopularYouTubersStepOne(@RequestParam(value = "genre", defaultValue = "tech") String genre) {
        PromptTemplate promptTemplate = new PromptTemplate(ytPromptResource);
        Prompt prompt = promptTemplate.create(Map.of("genre" ,genre));
        return chatClient.call(prompt).getResult().getOutput().getContent();
    }
}
