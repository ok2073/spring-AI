package com.keelient.hellogpt4o;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatModal {
    private final ChatClient chatClient;

    public ChatModal(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @PostMapping("/jokes")
    public String jokes(@RequestBody Map<String, String> requestBody) {
        String topic = requestBody.getOrDefault("topic", "Dogs");
        PromptTemplate promptTemplate = new PromptTemplate("Tell me a dad joke about {topic}");
        Prompt prompt = promptTemplate.create(Map.of("topic", topic));
        return chatClient.call(prompt).getResult().getOutput().getContent();
    }
}
