package utp.edu.pe.integrador.productor.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAIChatService {
    private final String apiUrl = "https://api.openai.com/v1/chat/completions";
    private final String apiKey = "";

    public String completeChat(String userMessage) {
        return completeChatWithContext(userMessage, null);
    }

    public String completeChatWithContext(String userMessage, String context) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        // Construir el cuerpo de la solicitud con contexto adicional si está disponible
        String systemContent = "";
        if (context != null && !context.isEmpty()) {
            systemContent += context;
        }

        String requestBody = String.format("{\"model\":\"gpt-3.5-turbo-0125\",\"messages\":[{\"role\":\"system\",\"content\":\"%s\"},{\"role\":\"user\",\"content\":\"%s\"}]}", systemContent, userMessage);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);
            return responseEntity.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            // Log the error details for debugging
            return "Error occurred while processing the request: " + e.getStatusCode() + " " + e.getResponseBodyAsString();
        } catch (Exception e) {
            return "An unexpected error occurred: " + e.getMessage();
        }
    }
}