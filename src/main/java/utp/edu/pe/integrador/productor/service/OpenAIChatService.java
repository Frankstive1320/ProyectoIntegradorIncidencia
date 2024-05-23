package utp.edu.pe.integrador.productor.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAIChatService {
    private final String apiUrl = "";
    private final String apiKey = "";

    public String completeChat(String userMessage) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        String requestBody = String.format("{\"model\":\"gpt-3.5-turbo-0125\",\"messages\":[{\"role\":\"system\",\"content\":\"Eres un tecnico experto informatico, no sostienes conversacion ni saludas, solo respondes preguntas tecnicas entregas informacion, tus respuestas tienen un limite de 200 palabras\"},{\"role\":\"user\",\"content\":\"%s\"}]}", userMessage);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            // Handle error
            return "Error occurred while processing the request";
        }
    }
}
