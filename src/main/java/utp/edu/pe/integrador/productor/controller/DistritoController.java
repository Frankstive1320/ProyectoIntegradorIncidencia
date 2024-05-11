package utp.edu.pe.integrador.productor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import utp.edu.pe.integrador.productor.interfacesservice.IDistritoService;
import utp.edu.pe.integrador.productor.model.Distrito;

import java.util.List;

@Controller
public class DistritoController {

    @Autowired
    private IDistritoService disservices;

    @GetMapping("/distrito")
    public String listar(Model model) {
        List<Distrito> distrito = disservices.listarDistritos();
        model.addAttribute("distrito",distrito);
        return "distritolistar";
    }
}
