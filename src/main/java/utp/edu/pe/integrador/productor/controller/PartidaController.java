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

import utp.edu.pe.integrador.productor.interfacesservice.IPartidaService;
import utp.edu.pe.integrador.productor.interfacesservice.IPartidacategoriaService;
import utp.edu.pe.integrador.productor.interfacesservice.ITipobaremoService;
import utp.edu.pe.integrador.productor.model.Partida;
import utp.edu.pe.integrador.productor.model.Partidacategoria;
import utp.edu.pe.integrador.productor.model.Tipobaremo;

@Controller
public class PartidaController {
	
	@Autowired
	private IPartidaService servicio;
	
	@Autowired
	private IPartidacategoriaService categoriaservicio;
	
	@Autowired
	private ITipobaremoService tipobaremoservicio;
	
	@GetMapping("/partida/")
	public String listar(Model model) {
		List<Tipobaremo> tipobaremos = tipobaremoservicio.listarTipobaremos();
		model.addAttribute("tipobaremos", tipobaremos);
		List<Partida> partidas = servicio.listarPartidas();
		model.addAttribute("partidas", partidas);
		return "Partidaslistar";
	}
	
	@GetMapping("/partida/nuevoCategoria")
	public String nuevoCategoria(Model model) {
		List<Partidacategoria> partidacategorias = categoriaservicio.listarPartidacategorias();
		model.addAttribute("partidacategorias", partidacategorias);
		List<Tipobaremo> tipobaremos = tipobaremoservicio.listarTipobaremos();
		model.addAttribute("tipobaremos", tipobaremos);
		model.addAttribute("partida", new Partida());
		return "PartidaformNuevo";
	}
	
	@PostMapping("/partida/grabar")
	public String grabar(@Validated @ModelAttribute Partida pPartida,
		BindingResult result, Model model, RedirectAttributes atributo) {
		if (result.hasErrors()) {
			model.addAttribute("partida", pPartida);
			return "PartidaformNuevo";
		}		
		servicio.grabarPartida(pPartida);
		atributo.addFlashAttribute("success","PARTIDA REGISTRADA CORRECTAMENTE");
		return "redirect:/partida/";
	}
	
	@GetMapping("/partida/editar/{codigo}")
	public String editar(@PathVariable int codigo, Model model, RedirectAttributes atributo) {
		Partida p = null;
		if (codigo > 0) {
			p = servicio.partidaPorCodigo(codigo);
			if (p==null) {
				atributo.addFlashAttribute("error","Registro no existe");
				return "redirect:/partida/";
		}
		}
		else {
			atributo.addFlashAttribute("error","Error con el registro");
			return "redirect:/partidacategoria/";
		}
		List<Partidacategoria> partidacategorias = categoriaservicio.listarPartidacategorias();
		model.addAttribute("partidacategorias", partidacategorias);
		List<Tipobaremo> tipobaremos = tipobaremoservicio.listarTipobaremos();
		model.addAttribute("tipobaremos", tipobaremos);
		model.addAttribute("partida", p);
		return "PartidaformEditar";
	}
	
	@GetMapping("/partida/eliminar/{codigo}")
	public String delete(@PathVariable int codigo, Model model, RedirectAttributes atributo) {
		Partida p = null;
		if (codigo > 0) {
			p = servicio.partidaPorCodigo(codigo);
		if (p==null) {
			atributo.addFlashAttribute("error","REGISTRO NO EXISTE");
			return "redirect:/partida/";
		}
		}
		else {
			atributo.addFlashAttribute("error","ERROR CON LA ELIMINACIÓN");
			return "redirect:/partida/";
		}
		try {
			servicio.eliminarPartida(codigo);
			atributo.addFlashAttribute("success","PARTIDA ELIMINADA CORRECTAMENTE");
			return "redirect:/partida/";} 
			
		catch(Exception ex) {
			atributo.addFlashAttribute("error","NO PUEDE ELIMINAR UNA  PARTIDA CON REGISTROS");
			return "redirect:/partida/";
		}
	}
	
}
