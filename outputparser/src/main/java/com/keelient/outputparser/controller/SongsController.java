package com.keelient.outputparser.controller;

import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")

public class SongsController {

    private final ChatClient chatClient;


}
