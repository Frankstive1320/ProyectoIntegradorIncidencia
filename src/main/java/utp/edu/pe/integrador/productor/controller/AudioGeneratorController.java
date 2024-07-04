package utp.edu.pe.integrador.productor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.integrador.productor.service.AudioGeneratorService;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/tts")
public class AudioGeneratorController {

    @Autowired
    private AudioGeneratorService audioGeneratorService;

    @PostMapping("/generate")
    public void generateTextToSpeech(@RequestBody Map<String, String> requestBody) {
        try {
            String text = requestBody.get("text");
            String outputFile = "output.wav";
            audioGeneratorService.generateAudio(text, outputFile);

            // Esperar un poco antes de reproducir el archivo
            Thread.sleep(1000);
            playAudio(outputFile);
            deleteFile(outputFile);

        } catch (IOException | InterruptedException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    private void playAudio(String filename) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        File audioFile = new File(filename);

        if (!audioFile.exists()) {
            System.err.println("El archivo de audio no existe: " + filename);
            return;
        }

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);

        Clip audioClip = (Clip) AudioSystem.getLine(info);
        audioClip.open(audioStream);
        audioClip.start();

        audioClip.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
                audioClip.close();
                try {
                    audioStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        while (!audioClip.isRunning()) {
            Thread.yield();
        }
        while (audioClip.isRunning()) {
            Thread.yield();
        }
    }

    private void deleteFile(String filename) {
        File fileToDelete = new File(filename);
        if (fileToDelete.exists() && fileToDelete.delete()) {
            System.out.println("Archivo eliminado: " + filename);
        } else {
            System.err.println("No se pudo eliminar el archivo: " + filename);
        }
    }
}
