package utp.edu.pe.integrador.productor.service;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.regex.Pattern;

@Service
public class AIMLProcessor {
    private Bot bot;


    public AIMLProcessor() {
        // Inicializar el bot y cargar los archivos AIML
        bot = new Bot("super", "src/main/resources");
        bot.writeAIMLIFFiles();
    }

    public String getResponse(String userInput) {
        // Normalizar el texto antes de enviarlo al AIML
        String normalizedInput = normalizeText(userInput);

        // Obtener la respuesta del bot para la entrada del usuario
        Chat chatSession = new Chat(bot);
        String response = chatSession.multisentenceRespond(normalizedInput);

        // Si la respuesta es "I have no answer for that.", devolver cadena vacía
        if ("I have no answer for that.".equals(response)) {
            return "Eres un asistente virtual experto en infraestructura, redes e informatica. Tus repuestas tienen un limite de 100 palabras";
        }
        else{
            response="Eres un asistente virtual experto en informatica, las preguntas estaran basadas en el software/proceso/negocio/contexto donde esta montada esta IA, tus respuestas deben basarse en la siguiente informacion: "+response;
        }

        return response;
    }

    private String normalizeText(String input) {
        // Eliminar tildes
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        normalized = pattern.matcher(normalized).replaceAll("");

        // Eliminar signos de exclamación e interrogación
        normalized = normalized.replaceAll("[¡!¿?]", "");

        return normalized;
    }
}