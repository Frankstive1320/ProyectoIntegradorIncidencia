package utp.edu.pe.integrador.productor.controller;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import utp.edu.pe.integrador.productor.interfacesservice.ICertificacionaveriaService;
import utp.edu.pe.integrador.productor.interfacesservice.IPartidaService;
import utp.edu.pe.integrador.productor.interfacesservice.IPartidacertificacionaveriaService;
import utp.edu.pe.integrador.productor.model.Averias;
import utp.edu.pe.integrador.productor.model.Certificacionaveria;
import utp.edu.pe.integrador.productor.model.Partida;
import utp.edu.pe.integrador.productor.model.Partidacertificacionaveria;


@Controller
public class PartidacertificacionaveriaController {
	
	@Autowired
	private IPartidacertificacionaveriaService servicio;
	
	@Autowired
	private IPartidaService partidaservicio;
	
	@Autowired
	private ICertificacionaveriaService certificacionservicio;
	
	
	@GetMapping("/partidacertificacionaveria/{codigo}")
	public String listar(@PathVariable int codigo, Model model) {
		List<Partida> partidas = partidaservicio.listarPartidas();
		model.addAttribute("partidas", partidas);
		List<Certificacionaveria> certificaciones = certificacionservicio.listarCertificacionesaveria();
		model.addAttribute("certificaciones", certificaciones);
		List<Partidacertificacionaveria> partidacertificaciones = servicio.listarPartidasdeCertificacionaveria(codigo);
		model.addAttribute("partidacertificaciones", partidacertificaciones);
		return "Partidacertificacionaverialistar";
	}
	
	@GetMapping("/partidacertificacionaveria/nuevoPartidacertificacionaveria/{codigo}")
	public String nuevoPartidacertificacion(@PathVariable int codigo, Model model) {
		List<Partida> partidas = partidaservicio.listaPartidasAverias();
		model.addAttribute("partidas", partidas);
		List<Certificacionaveria> certificacionaveria =certificacionservicio.SeleccionCertificacion(codigo);
		model.addAttribute("certificaciones", certificacionaveria);
		model.addAttribute("partidacertificacionaveria", new Partidacertificacionaveria());
		return "PartidacertificacionaveriaformNuevo";
	}
	
	@GetMapping("/partidacertificacionaveria/editarPartidacertificacionaveria/{codigo}")
	public String EditarPartidacertificacion(@PathVariable int codigo, Model model) {
		
	    Partidacertificacionaveria pca =null;
	    pca = servicio.partidacertificacionaveriaPorCodigo(codigo);
	    model.addAttribute("partidacertificacionaveria", pca);
		List<Partida> partidas = partidaservicio.listaPartidasAverias();
		model.addAttribute("partidas", partidas);
		List<Certificacionaveria> certificaciones = certificacionservicio.SeleccionCertificacion(codigo);
		model.addAttribute("certificaciones", certificaciones);
		//model.addAttribute("partidacertificacionaveria", new Partidacertificacionaveria());
		return "PartidacertificacionaveriaEditar";
	}
	
	
	@PostMapping("/partidacertificacionaveria/grabar")
	public String grabar(@Validated @ModelAttribute Partidacertificacionaveria pPartidacertificacionaveria,
		BindingResult result, Model model, RedirectAttributes atributo) {
		
		if (result.hasErrors()) {
			List<Partida> partidas = partidaservicio.listaPartidasAverias();
			model.addAttribute("partidas", partidas);
			List<Certificacionaveria> certificaciones = certificacionservicio.listarCertificacionesaveria();
			model.addAttribute("certificaciones", certificaciones);
			model.addAttribute("partidacertificacionaveria", pPartidacertificacionaveria);
			return "PartidacertificacionformNuevo";
		}
		Partidacertificacionaveria partidascertificadas = servicio.buscarpartidacertificaionaveria(pPartidacertificacionaveria.getPartida().getPartidaid(),pPartidacertificacionaveria.getCertificacionaveria().getCertificacionaveriaid() );
		pPartidacertificacionaveria.setCantidadpartida(1);
		if(partidascertificadas != null){
			
		  servicio.actualizarpartidacertificaionaveria(pPartidacertificacionaveria.getPartida().getPartidaid(),pPartidacertificacionaveria.getCertificacionaveria().getCertificacionaveriaid())	;
		}else {
			
			servicio.grabarPartidacertificacionaveria(pPartidacertificacionaveria);
		}
		
		
		atributo.addFlashAttribute("success","PARTIDA INGRESADA CORRECTAMENTE - " + pPartidacertificacionaveria.getPartida().getPartidadescripcion());
		return "redirect:/partidacertificacionaveria/nuevoPartidacertificacionaveria/" + pPartidacertificacionaveria.getCertificacionaveria().getCertificacionaveriaid();
	}
	
	@GetMapping("/partidacertificacionaveria/reporte")
	public ResponseEntity<InputStreamResource> exportReporteCertificacionAveria(@RequestParam(name = "fechaparafinalizar") String fechainicio, @RequestParam(name = "fechafinalizacion") 
	String fechafin) throws Exception{
				
		Date ahora = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		String fecha = hourdateFormat.format(ahora);
				 
		ByteArrayInputStream stream = servicio.exportPartidasAverias2(fechainicio, fechafin);
				
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","attachment; filename=Certificacion Averias " + fecha +".xls");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
				
	}
	
	@GetMapping("/partidacertificacionaveria/reporte/web")
	public String ReporteCerAverias(Model model) {
		model.addAttribute("averias", new Averias());
		return "ReportePartidasAverias";
	}
	
}
