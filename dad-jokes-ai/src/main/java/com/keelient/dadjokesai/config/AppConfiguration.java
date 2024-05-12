package com.keelient.dadjokesai.config;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    ChatClient chatClient(@Value("${spring.ai.openai.api-key}") String apiKey) {
        return new OpenAiChatClient(new OpenAiApi(apiKey));
    }

}
