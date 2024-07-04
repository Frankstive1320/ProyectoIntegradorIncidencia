package utp.edu.pe.integrador.productor.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AudioGeneratorService {

    private static final String ESPEAK_NG_PATH = "C:\\Program Files\\eSpeak NG\\espeak-ng.exe";

    public void generateAudio(String text, String outputFile) throws IOException, InterruptedException {
        // Construir el comando para eSpeak NG
        ProcessBuilder pb = new ProcessBuilder(
                ESPEAK_NG_PATH,
                "-w", outputFile, // Nombre del archivo de salida
                "-v", "es", // Voz en español
                "-s", "150", // Ajusta la velocidad de habla (valor entre 80 y 450)
                "-a", "100", // Ajusta la entonación (valor entre 0 y 100)
                "\"" + text + "\""  // Texto a convertir a voz
        );

        pb.redirectErrorStream(true);
        Process process = pb.start();

        // Esperar a que termine el proceso
        process.waitFor();
    }
}
