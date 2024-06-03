package utp.edu.pe.integrador.productor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatFlotante {

    @GetMapping("/chatbot")
    public String chatbot() {
        return "chatflotante";
    }
}
