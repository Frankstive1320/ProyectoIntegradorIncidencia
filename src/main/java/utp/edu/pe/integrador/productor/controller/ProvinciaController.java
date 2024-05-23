package utp.edu.pe.integrador.productor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import utp.edu.pe.integrador.productor.interfacesservice.IDepartamentoService;
import utp.edu.pe.integrador.productor.interfacesservice.IProvinciaService;
import utp.edu.pe.integrador.productor.model.Departamento;
import utp.edu.pe.integrador.productor.model.Provincia;

import java.util.List;

@Controller
public class ProvinciaController {

    @Autowired
    private IProvinciaService proservices;
    @Autowired
    private IDepartamentoService depservices;

    @GetMapping("/provincia/{codigo}")
    public String listar(@PathVariable int codigo, Model model) {
        List<Provincia> provincia = proservices.listarProvincias(codigo);
        model.addAttribute("provincia",provincia);
        return "provincialistar";
    }
}
