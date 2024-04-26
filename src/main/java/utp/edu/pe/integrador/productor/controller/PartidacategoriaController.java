package utp.edu.pe.integrador.productor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import utp.edu.pe.integrador.productor.interfacesservice.IPartidacategoriaService;
import utp.edu.pe.integrador.productor.model.Partidacategoria;

@Controller
public class PartidacategoriaController {
	
	@Autowired
	private IPartidacategoriaService servicio;
	
	@GetMapping("/partidacategoria/")
	public String listar(Model model) {
		List<Partidacategoria> partidacategorias = servicio.listarPartidacategorias();
		model.addAttribute("partidacategorias", partidacategorias);
		return "Partidacategoriaslistar";
	}
	
	@GetMapping("/partidacategoria/nuevoCategoria")
	public String nuevoCategoria(Model model) {
		model.addAttribute("partidacategoria", new Partidacategoria());
		return "PartidacategoriaformNuevo";
	}
	
	@PostMapping("/partidacategoria/grabar")
	public String grabar(@Validated @ModelAttribute Partidacategoria pPartidacategoria,
		BindingResult result, Model model, RedirectAttributes atributo) {
		if (result.hasErrors()) {
			model.addAttribute("partidacategoria", pPartidacategoria);
			return "PartidacategoriaformNuevo";
		}
		servicio.grabarPartidacategoria(pPartidacategoria);
		atributo.addFlashAttribute("success","CATEGORIA DE PARTIDA REGISTRADA CORRECTAMENTE");
		return "redirect:/partidacategoria/";
	}
	
	@GetMapping("/partidacategoria/editar/{codigo}")
	public String editar(@PathVariable int codigo, Model model, RedirectAttributes atributo) {
		Partidacategoria p = null;
		if (codigo > 0) {
			p = servicio.PartidacategoriaPorCodigo(codigo);
			if (p==null) {
				atributo.addFlashAttribute("error","Registro no existe");
				return "redirect:/partidacategoria/";
		}
		}
		else {
			atributo.addFlashAttribute("error","Error con el registro");
			return "redirect:/partidacategoria/";
		}
		model.addAttribute("partidacategoria", p);
		return "PartidacategoriaformEditar";
	}
	
	@GetMapping("/partidacategoria/eliminar/{codigo}")
	public String delete(@PathVariable int codigo, Model model, RedirectAttributes atributo) {
		Partidacategoria p = null;
		if (codigo > 0) {
			p = servicio.PartidacategoriaPorCodigo(codigo);
		if (p==null) {
			atributo.addFlashAttribute("error","REGISTRO NO EXISTE");
			return "redirect:/partidacategoria/";
		}
		}
		else {
			atributo.addFlashAttribute("error","ERROR CON LA ELIMINACIÓN");
			return "redirect:/partidacategoria/";
		}
		try {
			servicio.eliminarPartidacategoria(codigo);
			atributo.addFlashAttribute("success","CATEGORIA DE PARTIDA ELIMINADA CORRECTAMENTE");
			return "redirect:/partidacategoria/";} 
			
		catch(Exception ex) {
			atributo.addFlashAttribute("error","NO PUEDE ELIMINAR UNA CATEGORIA DE PARTIDA CON REGISTROS");
			return "redirect:/partidacategoria/";
		}
	}

}
