package utp.edu.pe.integrador.productor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import utp.edu.pe.integrador.productor.interfacesservice.IDepartamentoService;

@Controller
public class AsistenteVirtualController {

    @Autowired
    private IDepartamentoService depservices;

    @GetMapping("/asistente")
    public String listar(Model model) {
//        List<Departamento> departamento = depservices.listarDepartamentos();
//        model.addAttribute("departamento",departamento);
        return "asistentevirtual";
    }
}
