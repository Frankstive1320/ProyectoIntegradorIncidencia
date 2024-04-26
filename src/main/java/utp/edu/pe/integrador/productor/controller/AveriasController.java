package utp.edu.pe.integrador.productor.controller;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import utp.edu.pe.integrador.productor.entity.User;
import utp.edu.pe.integrador.productor.interfacesservice.IAveriasService;
import utp.edu.pe.integrador.productor.interfacesservice.IUserService;
import utp.edu.pe.integrador.productor.model.Averias;


@Controller
public class AveriasController {
	
	@Autowired
	private IAveriasService avservices;
	

	
	@Autowired
	private IUserService userservicio;
	
	
	@GetMapping("/averias/")
	public String listar(Model model) {
		List<Averias> averias = avservices.listaraveriasenplanta2();
		model.addAttribute("averias",averias);
		return "averiaslistar";
	}
	@GetMapping("/averias1/")
	public String listarhistorial(Model model) {
		List<Averias> averias = avservices.listarAveria();
		model.addAttribute("averias",averias);
		return "averiaslistar1";
	}
	@GetMapping("/averiasportecnico/{usuario}")
	public String listaraveriaportecnico(@PathVariable String usuario,Model model) {
		List<Averias> averias = avservices.listarAveriasportecnico(usuario);
		model.addAttribute("averias",averias);
		return "averiaslistartecnico";
	}
	
	
	@GetMapping("/averias/nuevaAveria")
	public String nuevoProducto(Model model) {
		List<User> users = userservicio.listarTecnicos();
		model.addAttribute("users", users);
		model.addAttribute("averias", new Averias());
		return "AveriaformNuevo2";
	}
	
	@PostMapping("/averias/grabar")
	public String grabar(@Validated @ModelAttribute Averias pAveria,
			BindingResult result, Model model, RedirectAttributes atributo)
	{
		if (result.hasErrors()) {
			List<User> users = userservicio.listarUsers();
			model.addAttribute("users", users);
			model.addAttribute("averias", pAveria);
			return "AveriaformNuevo";
		}
		avservices.grabarAverias(pAveria);
		
		atributo.addFlashAttribute("success","AVERIA REGISTRADA CORRECTAMENTE");
		return "redirect:/averias/";
	}
	@PostMapping("/averias/grabarportecnico")
	public String grabarportecnico(@Validated @ModelAttribute Averias pAveria, 
			BindingResult result, Model model, RedirectAttributes atributo)
	{
		if (result.hasErrors()) {
			List<User> users = userservicio.listarUsers();
			model.addAttribute("users", users);
			model.addAttribute("averias", pAveria);
			return "AveriaformNuevo";
		}
		avservices.grabarAverias(pAveria);
		String nombretecnico = pAveria.getContrata(); 
		
		atributo.addFlashAttribute("success","AVERIA REGISTRADA CORRECTAMENTE");
		return "redirect:/averiasportecnico/"+ nombretecnico;
	}
	
	@GetMapping("/averias/editar/{codigo}")
	public String editar(@PathVariable int codigo, Model model, RedirectAttributes atributo) {
		Averias p = null;
		if (codigo > 0) {
			p = avservices.averiaPorCodigo(codigo);
			if (p==null) {
				atributo.addFlashAttribute("error","Registro no existe");
				return "redirect:/averias/";
		}
	}else {
		atributo.addFlashAttribute("error","Error con el registro");
		return "redirect:/caja/";
		}
		List<User> users = userservicio.listarTecnicos();
		model.addAttribute("users", users);
		model.addAttribute("averias",p);
		return "AveriasFormEditar";
	}
	@GetMapping("/averias/editaraveriaportecnico/{codigo}")
	public String editarportecnico(@PathVariable int codigo, Model model, RedirectAttributes atributo) {
		Averias p = null;
		if (codigo > 0) {
			p = avservices.averiaPorCodigo(codigo);
			if (p==null) {
				atributo.addFlashAttribute("error","Registro no existe");
				return "redirect:/averias/";
		}
	}else {
		atributo.addFlashAttribute("error","Error con el registro");
		return "redirect:/caja/";
		}
		List<User> users = userservicio.listarTecnicos();
		model.addAttribute("users", users);
		model.addAttribute("averias",p);
		return "AveriasFormEditarTecnico";
	}
	
	@GetMapping("/averias/eliminar/{codigo}")
	public String eliminar(@PathVariable int codigo, Model model, RedirectAttributes atributo)
	{
		Averias p = null;
		if(codigo >0) {
			p = avservices.averiaPorCodigo(codigo);
		if(p==null) {
			atributo.addFlashAttribute("error","REGISTRO NO EXISTE");
			return "redirect:/averias/";
		}
		}else {
			atributo.addFlashAttribute("error","ERROR CON LA ELIMINACIÓN");
			return "redirect:/averias/";
		}try {
			avservices.eliminarAverias(codigo);
			atributo.addFlashAttribute("success","REGISTRO ELIMINADO CORRECTAMENTE");
			return "redirect:/averias/";
		} 
			
		catch(Exception ex) {
			atributo.addFlashAttribute("error","NO PUEDE ELIMINAR REGISTROS");
			return "redirect:/averias/";
		}
	}

	@GetMapping("/averias/export/all")
	public ResponseEntity<InputStreamResource> exportarAverias() throws Exception 
	{
		Date ahora = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		String fecha = hourdateFormat.format(ahora);
		
		ByteArrayInputStream stream = avservices.exportAllDta();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","attachment; filename=Reporte General de averias "+ fecha +".xls");
		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
	}
	
	@GetMapping("/averias/reporte")
	public String ReporteSolicitud(Model model) {
		model.addAttribute("solicitud", new Averias());
		return "AveriaReporte";		
	}
	
}
