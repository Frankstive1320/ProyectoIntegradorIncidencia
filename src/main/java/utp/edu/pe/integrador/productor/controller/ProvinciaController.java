package utp.edu.pe.integrador.productor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import utp.edu.pe.integrador.productor.interfacesservice.IProvinciaService;
import utp.edu.pe.integrador.productor.model.Provincia;

import java.util.List;

@Controller
public class ProvinciaController {

    @Autowired
    private IProvinciaService proservices;

    @GetMapping("/provincia")
    public String listar(Model model) {
        List<Provincia> provincia = proservices.listarProvincias();
        model.addAttribute("provincia",provincia);
        return "provincialistar";
    }
}
