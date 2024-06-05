package utp.edu.pe.integrador.productor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utp.edu.pe.integrador.productor.service.AIMLProcessor;
import utp.edu.pe.integrador.productor.service.OpenAIChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private OpenAIChatService openAIChatService;

    @Autowired
    private AIMLProcessor aimlProcessor;

    @PostMapping("/complete")
    public String completeChat(@RequestParam String userMessage) {
        // Procesar la entrada del usuario con AIML
        String aimlResponse = aimlProcessor.getResponse(userMessage);

        // Verificar si AIML tiene una respuesta predefinida
        if (aimlResponse != null && !aimlResponse.isEmpty()) {
            // Enviar la respuesta de AIML como contexto adicional
            return openAIChatService.completeChatWithContext(userMessage, aimlResponse);
        } else {
            // Si no hay respuesta AIML, usar el mensaje del usuario directamente
            return openAIChatService.completeChat(userMessage);
        }
    }
}