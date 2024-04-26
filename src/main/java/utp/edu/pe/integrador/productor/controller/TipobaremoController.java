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

import utp.edu.pe.integrador.productor.interfacesservice.ITipobaremoService;
import utp.edu.pe.integrador.productor.model.Tipobaremo;

@Controller
public class TipobaremoController {
	
	@Autowired
	private ITipobaremoService servicio;
	
	@GetMapping("/tipobaremo/")
	public String listar(Model model) {
		List<Tipobaremo> tipobaremos = servicio.listarTipobaremos();
		model.addAttribute("tipobaremos", tipobaremos);
		return "Tipobaremoslistar";
	}
	
	@GetMapping("/tipobaremo/nuevoTipobaremo")
	public String nuevoTipoBaremo(Model model) {
		model.addAttribute("tipobaremo", new Tipobaremo());
		return "TipobaremoformNuevo";
	}
	
	@PostMapping("/tipobaremo/grabar")
	public String grabar(@Validated @ModelAttribute Tipobaremo pTipobaremo,
		BindingResult result, Model model, RedirectAttributes atributo) {
		if (result.hasErrors()) {
			model.addAttribute("tipobaremo", pTipobaremo);
			return "TipobaremoformNuevo";
		}
		servicio.grabarTipobaremo(pTipobaremo);
		atributo.addFlashAttribute("success","TIPO DE BAREMO REGISTRADO CORRECTAMENTE");
		return "redirect:/tipobaremo/";
	}
	
	@GetMapping("/tipobaremo/editar/{codigo}")
	public String editar(@PathVariable int codigo, Model model, RedirectAttributes atributo) {
		Tipobaremo p = null;
		if (codigo > 0) {
			p = servicio.tipobaremoPorCodigo(codigo);
			if (p==null) {
				atributo.addFlashAttribute("error","Registro no existe");
				return "redirect:/tipobaremo/";
		}
		}
		else {
			atributo.addFlashAttribute("error","Error con el registro");
			return "redirect:/tipobaremo/";
		}
		model.addAttribute("tipobaremo", p);
		return "TipobaremoformEditar";
	}
	
	@GetMapping("/tipobaremo/eliminar/{codigo}")
	public String delete(@PathVariable int codigo, Model model, RedirectAttributes atributo) {
		Tipobaremo p = null;
		if (codigo > 0) {
			p = servicio.tipobaremoPorCodigo(codigo);
		if (p==null) {
			atributo.addFlashAttribute("error","REGISTRO NO EXISTE");
			return "redirect:/tipobaremo/";
		}
		}
		else {
			atributo.addFlashAttribute("error","ERROR CON LA ELIMINACIÓN");
			return "redirect:/tipobaremo/";
		}
		try {
			servicio.eliminarTipobaremo(codigo);
			atributo.addFlashAttribute("success","TIPO DE BAREMO ELIMINADO CORRECTAMENTE");
			return "redirect:/tipobaremo/";} 
			
		catch(Exception ex) {
			atributo.addFlashAttribute("error","NO PUEDE ELIMINAR UN TIPO DE BAREMO CON REGISTROS");
			return "redirect:/tipobaremo/";
		}
	}


}
