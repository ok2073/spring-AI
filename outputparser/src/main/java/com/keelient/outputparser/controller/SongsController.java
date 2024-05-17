package com.keelient.outputparser.controller;

import lombok.AllArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.parser.ListOutputParser;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/songs")
@AllArgsConstructor
public class SongsController {

    private final ChatClient chatClient;

    @GetMapping
    public String getSongsByArtist(@RequestParam(value = "artist", defaultValue = "Taylor Swift") String artist) {
        var message = """
                Please give me a list of top 10 songs for the artist {artist}.  If you don't know the answer , just say "I don't know".
                """;
        PromptTemplate promptTemplate = new PromptTemplate(message, Map.of("artist", artist));
        Prompt prompt = promptTemplate.create();
        ChatResponse response = chatClient.call(prompt);
       return response.getResult().getOutput().getContent();
}

    @GetMapping("/outputParser")
    public List<String> getSongsByArtistOp(@RequestParam(value = "artist", defaultValue = "Taylor Swift") String artist) {
        var message = """
                Please give me a list of top 10 songs for the artist {artist}.  If you don't know the answer , just say "I don't know".
                {format}
                """;
        ListOutputParser listOutputParser = new ListOutputParser(new DefaultConversionService());

        PromptTemplate promptTemplate = new PromptTemplate(message, Map.of("artist", artist,"format", listOutputParser.getFormat()));
        Prompt prompt = promptTemplate.create();
        ChatResponse response = chatClient.call(prompt);
        return listOutputParser.parse(response.getResult().getOutput().getContent());
    }
}
