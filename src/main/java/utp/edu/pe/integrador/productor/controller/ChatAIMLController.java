package utp.edu.pe.integrador.productor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utp.edu.pe.integrador.productor.service.AIMLProcessor;

@RestController
@RequestMapping("/aiml")
public class ChatAIMLController {

    @Autowired
    private AIMLProcessor aimlProcessor;

    @PostMapping("/message")
    public String chat(@RequestBody String userInput) {
        // Procesar la entrada del usuario y obtener la respuesta del bot
        String response = aimlProcessor.getResponse(userInput);
        return response;
    }
}