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

import utp.edu.pe.integrador.productor.interfacesservice.IAveriasService;
import utp.edu.pe.integrador.productor.interfacesservice.ICertificacionaveriaService;
import utp.edu.pe.integrador.productor.interfacesservice.IPartidaService;
import utp.edu.pe.integrador.productor.model.Averias;
import utp.edu.pe.integrador.productor.model.Certificacionaveria;
import utp.edu.pe.integrador.productor.model.Partida;

@Controller
public class CertificacionaveriaController {
	
	@Autowired
	private ICertificacionaveriaService servicio;
	
	@Autowired
	private IAveriasService averiaservicio;
	
	@Autowired
	private IPartidaService partidaservicio;
	
	@GetMapping("/certificacionaveria/{usuario}")
	public String listar(@PathVariable String usuario, Model model) {
		List<Averias> averias = averiaservicio.listarAveria();
		model.addAttribute("averias", averias);
		List<Partida> partidas = partidaservicio.listarPartidas();
		model.addAttribute("partidas", partidas);
		List<Certificacionaveria> certificacionaverias = servicio.SeleccionListadoCertificacionesaveria(usuario);
		model.addAttribute("certificacionaverias", certificacionaverias);
		return "Certificacionesaverialistar";
	}
	
	@GetMapping("/busquedacertificacion/{cajaestado}")
	public String Busqueda(@PathVariable String cajaestado, Model model) {
		List<Averias> averias = averiaservicio.listarAveria();
		model.addAttribute("averias", averias);
		List<Partida> partidas = partidaservicio.listarPartidas();
		model.addAttribute("partidas", partidas);
		List<Certificacionaveria> certificacionaverias = servicio.SeleccionListadoCertificacionesaveria(cajaestado);
		model.addAttribute("certificacionaverias", certificacionaverias);
		return "Certificacionesaverialistar";
	}
	
	@GetMapping("/certificacionaveria/nuevoCertificacionaveria/{usuario}")
	public String nuevoCertificacion(@PathVariable String usuario, Model model) {
		List<Averias> averias = averiaservicio.listarAveriasSinCertificacion(usuario);
		model.addAttribute("averias", averias);
		List<Partida> partidas = partidaservicio.listaPartidasAverias();
		model.addAttribute("partidas", partidas);
		model.addAttribute("certificacionaveria", new Certificacionaveria());
		return "CertificacionaveriaformNuevo";
	}
	
	@PostMapping("/certificacionaveria/grabar")
	public String grabar(@Validated @ModelAttribute Certificacionaveria pCertificacionaveria,
		BindingResult result, Model model, RedirectAttributes atributo) {
		if (result.hasErrors()) {
			model.addAttribute("certificacionaveria", pCertificacionaveria);
			return "CertificacionaveriaformNuevo";
		}		
		List<Averias> averias = averiaservicio.listarAveria();
		model.addAttribute("averias", averias);
		List<Partida> partidas = partidaservicio.listaPartidasAverias();
		model.addAttribute("partidas", partidas);
		averiaservicio.ActualizarAveriaSinCertificacion(pCertificacionaveria.getAveria().getAveriaid());
		servicio.grabarCertificacionaveria(pCertificacionaveria);
		atributo.addFlashAttribute("success","CERTIFICACION REGISTRADA CORRECTAMENTE");
		return "redirect:/certificacionaveria/" + pCertificacionaveria.getAveria().getContrata();
	}

}
