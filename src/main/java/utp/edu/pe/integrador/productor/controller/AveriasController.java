package utp.edu.pe.integrador.productor.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;

import org.springframework.web.multipart.MultipartFile;

import utp.edu.pe.integrador.productor.entity.User;
import utp.edu.pe.integrador.productor.interfacesservice.IAveriasService;
import utp.edu.pe.integrador.productor.interfacesservice.IDepartamentoService;
import utp.edu.pe.integrador.productor.interfacesservice.IDistritoService;
import utp.edu.pe.integrador.productor.interfacesservice.IProvinciaService;
import utp.edu.pe.integrador.productor.interfacesservice.IUserService;
import utp.edu.pe.integrador.productor.model.Averias;
import utp.edu.pe.integrador.productor.model.Departamento;
import utp.edu.pe.integrador.productor.model.Distrito;
import utp.edu.pe.integrador.productor.model.Provincia;


@Controller
public class AveriasController {
	
	@Autowired
	private IAveriasService avservices;
	
	@Autowired
	private IUserService userservicio;
	
	@Autowired
	private IDepartamentoService departservicio;
	
	@Autowired
	private IProvinciaService provservicio;
	
	@Autowired
	private IDistritoService distriservicio;
	
	String inc=null;
	String sisego=null; 
	String zonal=null;
	String zonificacion=null; 
	String contrata=null;
	String tecnico_asignado=null; 
	String fecha_atencion=null; 
	String tipo_averia=null; 
	String diagnostico=null; 
	String parada_reloj=null;
	String acciones_correctivas=null;
	String estado=null; 
	String observaciones=null;
	String cliente=null;
	String departamento=null;
	String distrito=null; 
	String direccion=null; 
	String materiales=null;
	
	
	
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
		List<Departamento> departamentos = departservicio.listarDepartamentosActivos();
		model.addAttribute("users", users);
		model.addAttribute("departamentos", departamentos);
		model.addAttribute("averias", new Averias());
		return "AveriaformNuevo2";
	}
	
	@PostMapping("/averias/grabar")
	public String grabar(@Validated @ModelAttribute Averias pAveria,
			BindingResult result, Model model, RedirectAttributes atributo)
	{
		if (result.hasErrors()) {
			List<User> users = userservicio.listarUsers();
			List<Departamento> departamentos = departservicio.listarDepartamentosActivos();
			model.addAttribute("users", users);
			model.addAttribute("departamentos", departamentos);
			model.addAttribute("averias", pAveria);
			return "AveriaformNuevo2";
		}
		pAveria.setDepartamento(departservicio.BuscarDepartamentobyId(Integer.parseInt(pAveria.getDepartamento())).getNombreDepartamento());  
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
		List<Departamento> departamentos = departservicio.listarDepartamentosActivos();
		//List<Provincia> provincias = provservicio.listarProvinciasActivos();
		model.addAttribute("users", users);
		model.addAttribute("departamentos", departamentos);
		
		Distrito distrito = distriservicio.BuscarDistritobyNombre(p.getDistrito());
		List<Provincia> provincias = provservicio.listarProvinciasActivosDepartamento(Integer.parseInt(distrito.getCodDepartamento()));
		List<Distrito> distritos = distriservicio.listarDistritosActivosProvincia(Integer.parseInt(distrito.getCodProvincia()));
		p.setDepartamento(distrito.getCodDepartamento());
		model.addAttribute("provincia", distrito.getCodProvincia());
		model.addAttribute("distritos", distritos);
		model.addAttribute("provincias", provincias);
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
	
	//@GetMapping(value="/listarDepartamentos")
	//public @ResponseBody List<Departamento> listarDepartamentos(Model model) {
	//return departamentoService.listarDepartamentos();
	//}

	@GetMapping(value="/listarProvincias/{departamento}")
	public @ResponseBody List<Provincia> listarProvincias(Model model, @PathVariable("departamento") int departamento) {
	return provservicio.listarProvinciasActivosDepartamento(departamento);
	}

	@GetMapping(value="/listarDistritos/{provincia}")
	public @ResponseBody List<Distrito> listarDistritos(Model model, @PathVariable("provincia") int provincia) {
	return distriservicio.listarDistritosActivosProvincia(provincia);
	}
	
	@GetMapping("/averias/importar")
	public String cargar(Model model) {
		List<Averias> averias = avservices.listarAveria();
		model.addAttribute("averias", averias);
		return "AveriasImportar";
	}
	private List<String> mensajesError = new ArrayList<>();
	@PostMapping("/averias/importargrabar")
	public String grabar(@RequestParam("file") MultipartFile file, @Validated @ModelAttribute Averias averias,
		BindingResult result, Model model, RedirectAttributes atributo) throws MalformedURLException, IOException {
		if (result.hasErrors()) {
			model.addAttribute("averias", averias);
			return "AveriasImportar";
		}
		
		MultipartFile multipartFile = new MockMultipartFile("sourceFile.tmp", file.getBytes());

		File filea = new File("src/main/resources/targetFile.tmp");

		try (OutputStream os = new FileOutputStream(filea)) {
		    os.write(multipartFile.getBytes());
		}
		
		// Reinicia la lista de mensajes de error antes de leer el archivo
		 List<String> errores = LeerArchivosExcel(filea);
     	if (!errores.isEmpty()) {
            // Si hay errores, agregalos como atributo flash para mostrar en el frontend
            atributo.addFlashAttribute("errores", errores);
        } else {
            atributo.addFlashAttribute("success","AVERIA AGREGADA");
        }
		return "redirect:/averias/";
	}
	
	
	private  List<String> LeerArchivosExcel (File archivoDestino) {
		List<String> errores =new ArrayList<>();
		int contador = 1;
		try {
			WorkbookSettings opciones= new WorkbookSettings();
			opciones.setEncoding("iso-8859-1");
			Workbook ArchivoExcel = Workbook.getWorkbook(archivoDestino, opciones);
			for (int hojas = 0; hojas < ArchivoExcel.getNumberOfSheets(); hojas++) {
				Sheet hoja = ArchivoExcel.getSheet(hojas);
				int numColumnas = hoja.getColumns();
				int numFilas = hoja.getRows();
				String dato;
				for (int fila = 1; fila < numFilas; fila++) {
					 StringBuilder filaError = new StringBuilder();
					for (int columna = 0; columna < numColumnas; columna++) {
						dato = hoja.getCell(columna, fila).getContents();
						switch (contador) {
						case 1:
							inc = dato; contador++; break;
						case 2:
							sisego = dato; contador++; break;
						case 3:
							zonal = dato; contador++; break;
						case 4:
							zonificacion = dato; contador++; break;
						case 5:
							contrata = dato; contador++; break;
						case 6:
							tecnico_asignado = dato; contador++; break;
						case 7:
							fecha_atencion = dato; contador++; break;
						case 8:
							tipo_averia = dato; contador++; break;
						case 9:
							diagnostico = dato; contador++; break;
						case 10:
							parada_reloj = dato; contador++; break;
						case 11:
							acciones_correctivas = dato; contador++; break;
						case 12:
							estado = dato; contador++; break;
						case 13:
							observaciones = dato; contador++; break;
						case 14:
							cliente = dato; contador++; break;
						case 15:
							departamento = dato; contador++; break;
						case 16:
							distrito = dato; contador++; break;
						case 17:
							direccion = dato; contador++; break;
						case 18:
							materiales = dato; contador=1; break;						
						}
						
						
						
					}
					if (inc != "") {
						avservices.AgregarAveria(inc, sisego, zonal, zonificacion, contrata, tecnico_asignado, fecha_atencion, tipo_averia, diagnostico, parada_reloj, acciones_correctivas, estado, observaciones, cliente, departamento, distrito, direccion, materiales);
						
					}else {	
						 errores.add("Fila " + (fila + 1) + ": No se registro la averia porque no contiene Numero de Incidencia.");					
					}
					
				}
			}
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		return errores;
	}
}
