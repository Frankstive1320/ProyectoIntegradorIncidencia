package utp.edu.pe.integrador.productor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utp.edu.pe.integrador.productor.service.OpenAIChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private OpenAIChatService openAIChatService;

    @PostMapping("/complete")
    public String completeChat(@RequestParam String userMessage) {
        return openAIChatService.completeChat(userMessage);
    }
}