package utp.edu.pe.integrador.productor.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utp.edu.pe.integrador.productor.interfaces.IPartidacertificacionaveria;
import utp.edu.pe.integrador.productor.interfacesservice.IPartidaService;
import utp.edu.pe.integrador.productor.interfacesservice.IPartidacertificacionaveriaService;
import utp.edu.pe.integrador.productor.model.Partida;
import utp.edu.pe.integrador.productor.model.Partidacertificacionaveria;

@Service
public class PartidacertificacionaveriaService implements IPartidacertificacionaveriaService {
	
	@Autowired
	private IPartidacertificacionaveria par;
	
	@Autowired
	private IPartidaService serviciopartida;

	@Override
	public List<Partidacertificacionaveria> listarPartidacertificacionaverias() {
		return (List<Partidacertificacionaveria>) par.findAll();
	}

	@Override
	public int grabarPartidacertificacionaveria(Partidacertificacionaveria Partidacertificacionaveria) {
		int res=0;
		Partidacertificacionaveria partidacertificacionaveria = par.save(Partidacertificacionaveria);
		if (!partidacertificacionaveria.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public Partidacertificacionaveria partidacertificacionaveriaPorCodigo(int cod) {
		return par.findById(cod).orElse(null);
	}

	@Override
	public void eliminarPartidacertificacionaveria(int cod) {
		par.deleteById(cod);
	}

	@Override
	public List<Partidacertificacionaveria> listarPartidasdeCertificacionaveria(int codigo) {
		return (List<Partidacertificacionaveria>) par.listarPartidasdeCertificacionaveria(codigo);
	}

	@Override
	public ByteArrayInputStream exportPartidasAverias2(String fechainicio, String fechafin) throws Exception {
		
		Workbook workbook = new HSSFWorkbook();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		
		// PRECIARIO ACTUAL COBRA
		
		String[] columns5 = {"Item", "Tipo", "Descripción","PRF.", "BAREMO", "PRECIO LIMA", "PRECIO PROVINCIA"};

		Sheet sheet5 = workbook.createSheet("PRECIARIO ACTUAL COBRA");
		
		CellStyle style = workbook.createCellStyle();
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setAlignment(HorizontalAlignment.CENTER);
		
		Font font = workbook.createFont();  
		font.setBold(true);
		
		Font font1 = workbook.createFont();  
		font1.setBold(true);
		font1.setColor(IndexedColors.WHITE.index);
		
		CellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.ROYAL_BLUE.index);
		style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style2.setBorderBottom(BorderStyle.THIN);
		style2.setBorderTop(BorderStyle.THIN);
		style2.setBorderRight(BorderStyle.THIN);
		style2.setBorderLeft(BorderStyle.THIN);
		style2.setAlignment(HorizontalAlignment.CENTER);
		style2.setFont(font1);
		
		//CellStyle style2 = workbook.createCellStyle();
		//style2.setBorderBottom(BorderStyle.THIN);
		//style2.setBorderTop(BorderStyle.THIN);
		//style2.setBorderRight(BorderStyle.THIN);
		//style2.setBorderLeft(BorderStyle.THIN);
		
		//style2.setFont(font);
		//style2.setAlignment(HorizontalAlignment.CENTER);

		Row row5 = sheet5.createRow(1);
				
		double TotalPrecioLima = 0.0;
		double TotalPrecioProvincia = 0.0;
				
		for (int i = 0; i < columns5.length; i++) {
		Cell cell5 = row5.createCell(i + 1);
		cell5.setCellValue(columns5[i]);
		cell5.setCellStyle(style2);
		}

		List<Partida> partidas = serviciopartida.listarPartidas();
		int initRow5 = 2;
		for (Partida partida : partidas) {
		row5 = sheet5.createRow(initRow5);

		Cell cell2893 = row5.createCell(1);
		cell2893.setCellValue(initRow5 - 1);
		cell2893.setCellStyle(style);
		
		Cell cell2894 = row5.createCell(2);
		cell2894.setCellValue(partida.getTipobaremo().getTipobaremonombre());
		cell2894.setCellStyle(style);
		
		Cell cell2895 = row5.createCell(3);
		cell2895.setCellValue(partida.getPartidadescripcion());
		cell2895.setCellStyle(style);
		
		Cell cell2896 = row5.createCell(4);
		cell2896.setCellValue(partida.getPartidaum());
		cell2896.setCellStyle(style);
		
		Cell cell2897 = row5.createCell(5);
		cell2897.setCellValue(Double.parseDouble(partida.getPartidabaremo()));
		cell2897.setCellStyle(style);
		
		Cell cell2898 = row5.createCell(6);
		cell2898.setCellValue(partida.getTipobaremo().getTipobaremopreciolima());
		cell2898.setCellStyle(style);
		
		Cell cell2899 = row5.createCell(7);
		cell2899.setCellValue(partida.getTipobaremo().getTipobaremoprecioprovincia());
		cell2899.setCellStyle(style);
		
		initRow5++;
		}
		sheet5.autoSizeColumn(1);
		sheet5.autoSizeColumn(2);
		sheet5.autoSizeColumn(3);
		sheet5.autoSizeColumn(4);
		sheet5.autoSizeColumn(5);
		sheet5.autoSizeColumn(6);
		sheet5.autoSizeColumn(7);
		
		// PXQ
		
		String[] columns2 = {"NUMERO DE MATERIAL DE PROVEEDOR SEGÚN CATALOGO", "DESCRIPCION", "PRECIO LIMA", "PRECIO PROVINCIA","Q (QUANTITY / CANTIDAD) LIMA", "Q (QUANTITY / CANTIDAD) PROVINCIA", "PXQ LIMA", "PXQ PROVINCIA"};

		Sheet sheet2 = workbook.createSheet("PxQ");

		Row row2 = sheet2.createRow(1);
		
		for (int i = 0; i < columns2.length; i++) {
		Cell cell2 = row2.createCell(i);
		cell2.setCellStyle(style2);
		cell2.setCellValue(columns2[i]);
		}

		List<List<String>> partidacertificacionesaverias2 = this.listarCertificacionAverias(fechainicio, fechafin);
		int initRow2 = 2;
		for (List<String> partidacertificacionaveria : partidacertificacionesaverias2) {
		row2 = sheet2.createRow(initRow2);
		
		Cell cell3890 = row2.createCell(0);
		cell3890.setCellValue(Integer.parseInt(partidacertificacionaveria.get(0)));
		cell3890.setCellStyle(style);

		Cell cell3891 = row2.createCell(1);
		cell3891.setCellValue(partidacertificacionaveria.get(1));
		cell3891.setCellStyle(style);
		
		Cell cell3892 = row2.createCell(2);
		cell3892.setCellValue(Double.parseDouble(String.valueOf(BigDecimal.valueOf(Double.parseDouble(partidacertificacionaveria.get(2))).setScale(2,RoundingMode.HALF_UP))));
		cell3892.setCellStyle(style);
		
		Cell cell3893 = row2.createCell(3);
		cell3893.setCellValue(Double.parseDouble(String.valueOf(BigDecimal.valueOf(Double.parseDouble(partidacertificacionaveria.get(3))).setScale(2,RoundingMode.HALF_UP))));
		cell3893.setCellStyle(style);
		
		Cell cell3894 = row2.createCell(4);
		cell3894.setCellValue(Integer.parseInt(partidacertificacionaveria.get(4)));
		cell3894.setCellStyle(style);
		
		Cell cell3895 = row2.createCell(5);
		cell3895.setCellValue(Integer.parseInt(partidacertificacionaveria.get(5)));
		cell3895.setCellStyle(style);
		
		Cell cell3896 = row2.createCell(6);
		cell3896.setCellValue(Double.parseDouble(String.valueOf(BigDecimal.valueOf(Double.parseDouble(partidacertificacionaveria.get(6))).setScale(2,RoundingMode.HALF_UP))));
		cell3896.setCellStyle(style);
		
		Cell cell3897 = row2.createCell(7);
		cell3897.setCellValue(Double.parseDouble(String.valueOf(BigDecimal.valueOf(Double.parseDouble(partidacertificacionaveria.get(7))).setScale(2,RoundingMode.HALF_UP))));
		cell3897.setCellStyle(style);
		
		TotalPrecioLima = TotalPrecioLima + Double.parseDouble(String.valueOf(BigDecimal.valueOf(Double.parseDouble(partidacertificacionaveria.get(6))).setScale(2,RoundingMode.HALF_UP)));
		TotalPrecioProvincia = TotalPrecioProvincia +  Double.parseDouble(String.valueOf(BigDecimal.valueOf(Double.parseDouble(partidacertificacionaveria.get(7))).setScale(2,RoundingMode.HALF_UP)));
		initRow2++;
		}
		sheet2.autoSizeColumn(0);
		sheet2.autoSizeColumn(1);
		sheet2.autoSizeColumn(2);
		sheet2.autoSizeColumn(3);
		sheet2.autoSizeColumn(4);
		sheet2.autoSizeColumn(5);
		sheet2.autoSizeColumn(6);
		sheet2.autoSizeColumn(7);
		
		Row row3 = sheet2.createRow(initRow2);
		Cell cell300 = row3.createCell(6);
		cell300.setCellStyle(style2);
		cell300.setCellValue(TotalPrecioLima);
		Cell cell301 = row3.createCell(7);
		cell301.setCellStyle(style2);
		cell301.setCellValue(TotalPrecioProvincia);
		
		// DETALLE		
				
		String[] columns = {"ITEM", "INICIA","FINALIZA", "GESTOR TDP", "CD / DAS","LOCALIDAD" ,"DIRECCION" , "TIPO DE SERVICIO", "CLIENTE", "DESCRIPCION", "TOTAL", "OBSERVACION & RECOMENDACIONES",
				"Dep.", "Dist.", "CD", "CODIGO DE AVERIA","RESPONSABLE" , "TECNICO"};

		Sheet sheet = workbook.createSheet("Detalle");
		
		Row rowasd = sheet.createRow(0);
		Cell cellasd = rowasd.createCell(1);
		cellasd.setCellStyle(style2);
		cellasd.setCellValue("DETALLE DE ATENCIONES REALIZADAS ENTRE " + fechainicio + " Y " + fechafin);
		sheet.addMergedRegion(new CellRangeAddress(0,0,1,5));
		
		Row row = sheet.createRow(1);
		
		for (int i = 0; i < columns.length; i++) {
		Cell cell = row.createCell(i);
		cell.setCellValue(columns[i]);
		cell.setCellStyle(style2);
		}
		
		int idAveriaActual = 0;
		int itemActual = 1;

		List<Partidacertificacionaveria> partidacertificacionesaverias = this.listarPartidasdeCertificacionaveria3(fechainicio, fechafin);
		int initRow = 2;
				
		for (Partidacertificacionaveria partidacertificacionaveria : partidacertificacionesaverias) {
		row = sheet.createRow(initRow);
				
		if (initRow == 2) {
			Cell celdota = row.createCell(0);
			celdota.setCellValue("A" + String.format("%05d", itemActual));
			celdota.setCellStyle(style);
			
			idAveriaActual = partidacertificacionaveria.getCertificacionaveria().getAveria().getAveriaid();
			
			//DETALLES POR ITEM
			
			DecimalFormat df = new DecimalFormat("#.00");
			
			double TotalBaremoporItem = 0.00;
			int CantidadTotalporItem = 0;
			
			String[] columns6 = {"VALORIZACION DE SERVICIO"};

			Sheet sheet6 = workbook.createSheet("A" + String.format("%05d", itemActual));

			Row row6 = sheet6.createRow(0);
									
			for (int i = 0; i < columns6.length; i++) {
			Cell cell6 = row6.createCell(i);
			cell6.setCellStyle(style2);
			cell6.setCellValue(columns6[i]);
			}
			
			Row row61 = sheet6.createRow(2);
			Cell cell61 = row61.createCell(0);
			cell61.setCellStyle(style2);
			cell61.setCellValue("COBRA");
			Cell cell62 = row61.createCell(1);
			cell62.setCellStyle(style);
			cell62.setCellValue("A" + String.format("%05d", itemActual));
			
			Row row63 = sheet6.createRow(3);
			Cell cell64 = row63.createCell(0);
			cell64.setCellStyle(style2);
			cell64.setCellValue("INC");
			Cell cell65 = row63.createCell(1);
			cell65.setCellStyle(style);
			cell65.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getInc());
			
			Row row66 = sheet6.createRow(4);
			Cell cell67 = row66.createCell(0);
			cell67.setCellStyle(style2);
			cell67.setCellValue("SERVICIO");
			Cell cell68 = row66.createCell(1);
			cell68.setCellStyle(style);
			cell68.setCellValue("AVERIA");
			
			Row row69 = sheet6.createRow(5);
			Cell cell70 = row69.createCell(0);
			cell70.setCellStyle(style2);
			cell70.setCellValue("LUGAR");
			Cell cell71 = row69.createCell(1);
			cell71.setCellStyle(style);
			cell71.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getZonal());
			Cell cell72 = row69.createCell(6);
			cell72.setCellStyle(style2);
			cell72.setCellValue("GESTOR");
			Cell cell73 = row69.createCell(7);
			cell73.setCellStyle(style);
			cell73.setCellValue("SERVICE DESK-GICS");
			
			Row row74 = sheet6.createRow(6);
			Cell cell75 = row74.createCell(0);
			cell75.setCellStyle(style2);
			cell75.setCellValue("DIRECCION");
			Cell cell76 = row74.createCell(1);
			cell76.setCellStyle(style);
			cell76.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getDireccion());
			Cell cell77 = row74.createCell(6);
			cell77.setCellStyle(style2);
			cell77.setCellValue("VALIDA");
			Cell cell78 = row74.createCell(7);
			cell78.setCellStyle(style);
			cell78.setCellValue("");
			
			Row row79 = sheet6.createRow(7);
			Cell cell80 = row79.createCell(0);
			cell80.setCellStyle(style2);
			cell80.setCellValue("CD / DAS :");
			Cell cell81 = row79.createCell(1);
			cell81.setCellStyle(style);
			cell81.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getSisego());
			Cell cell82 = row79.createCell(6);
			cell82.setCellStyle(style2);
			cell82.setCellValue("INICIO :");
			Cell cell83 = row79.createCell(7);
			cell83.setCellStyle(style);
			cell83.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getFechaAtencion());
			
			Row row84 = sheet6.createRow(8);
			Cell cell85 = row84.createCell(0);
			cell85.setCellStyle(style2);
			cell85.setCellValue("CLIENTE :");
			Cell cell86 = row84.createCell(1);
			cell86.setCellStyle(style);
			cell86.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getObservaciones());
			Cell cell87 = row84.createCell(6);
			cell87.setCellStyle(style2);
			cell87.setCellValue("FINAL :");
			Cell cell88 = row84.createCell(7);
			cell88.setCellStyle(style);
			cell88.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getFechafinalizacion());
			
			String[] columns7 = {"Codigo", "Descripcion", "Unid", "Cant", "P. Unit", "TOTAL", "P. Unit", " ", "TOTAL", "Tecnico"};

			Row row7 = sheet6.createRow(10);
									
			for (int i = 0; i < columns7.length; i++) {
			Cell cell7 = row7.createCell(i);
			cell7.setCellStyle(style2);
			cell7.setCellValue(columns7[i]);
			}
			
			Row row91 = sheet6.createRow(11);
			Cell cell91 = row91.createCell(0);
			cell91.setCellStyle(style);
			cell91.setCellValue("TRANSPORTE Y MANTENIMIENTO");
			
			Cell cell92 = row91.createCell(4);
			cell92.setCellStyle(style);
			cell92.setCellValue("SUMINISTRO");
			
			Cell cell93 = row91.createCell(6);
			cell93.setCellStyle(style);
			cell93.setCellValue("INSTALACION");
			
			String[] columns9 = {"Actividad - Resolución de Averías Circuitos de Datos"};

			Row row9 = sheet6.createRow(12);
									
			for (int i = 0; i < columns9.length; i++) {
			Cell cell9 = row9.createCell(i);
			cell9.setCellStyle(style);
			cell9.setCellValue(columns9[i]);
			}

			List<Partidacertificacionaveria> partidas6 = this.listarPartidasdeCertificacionaveria2(partidacertificacionaveria.getCertificacionaveria().getCertificacionaveriaid(), fechainicio, fechafin);
			int initRow6 = 13;
			for (Partidacertificacionaveria partida : partidas6) {
			row6 = sheet6.createRow(initRow6);

			Cell celda1 = row6.createCell(0);
			celda1.setCellStyle(style);
			celda1.setCellValue(partida.getPartida().getPartidaid());
			Cell celda2 = row6.createCell(1);
			celda2.setCellStyle(style);
			celda2.setCellValue(partida.getPartida().getPartidadescripcion());
			Cell celda3 = row6.createCell(2);
			celda3.setCellStyle(style);
			celda3.setCellValue(partida.getPartida().getPartidaum());
			Cell celda333 = row6.createCell(3);
			celda333.setCellStyle(style);
			celda333.setCellValue(partida.getCantidadpartida());
			Cell celda334 = row6.createCell(4);
			celda334.setCellStyle(style);
			celda334.setCellValue(0.00);
			Cell celda335 = row6.createCell(5);
			celda335.setCellStyle(style);
			celda335.setCellValue(0.00);
			

			if (partida.getCertificacionaveria().getAveria().getZonal().toLowerCase().equals("lima")) {
				
				Cell celda336 = row6.createCell(6);
				celda336.setCellStyle(style);
				celda336.setCellValue(df.format((partida.getPartida().getTipobaremo().getTipobaremopreciolima())*(Double.parseDouble(partida.getPartida().getPartidabaremo()))));
				//Cell celda337 = row6.createCell(7);
				//celda337.setCellStyle(style);
				//celda337.setCellValue(df.format((partida.getPartida().getTipobaremo().getTipobaremopreciolima())*(Double.parseDouble(partida.getPartida().getPartidabaremo()))));
				
				Cell celda338 = row6.createCell(8);
				celda338.setCellStyle(style);
				BigDecimal preciounitario= BigDecimal.valueOf(partida.getPartida().getTipobaremo().getTipobaremopreciolima()).multiply(BigDecimal.valueOf(Double.parseDouble(partida.getPartida().getPartidabaremo()))).setScale(2,RoundingMode.HALF_UP);
				celda338.setCellValue(String.valueOf(preciounitario.multiply(BigDecimal.valueOf(partida.getCantidadpartida())).setScale(2,RoundingMode.HALF_UP)));
				
			} else {
				
				Cell celda336 = row6.createCell(6);
				celda336.setCellStyle(style);
				celda336.setCellValue(Double.parseDouble(df.format((partida.getPartida().getTipobaremo().getTipobaremoprecioprovincia())*(Double.parseDouble(partida.getPartida().getPartidabaremo())))));
				//Cell celda337 = row6.createCell(7);
				//celda337.setCellStyle(style);
				//celda337.setCellValue(Double.parseDouble(df.format((partida.getPartida().getTipobaremo().getTipobaremoprecioprovincia())*(Double.parseDouble(partida.getPartida().getPartidabaremo())))));
				Cell celda338 = row6.createCell(8);
				celda338.setCellStyle(style);
				BigDecimal preciounitario= BigDecimal.valueOf(partida.getPartida().getTipobaremo().getTipobaremoprecioprovincia()).multiply(BigDecimal.valueOf(Double.parseDouble(partida.getPartida().getPartidabaremo()))).setScale(2,RoundingMode.HALF_UP);
		
				celda338.setCellValue(String.valueOf(preciounitario.multiply(BigDecimal.valueOf(partida.getCantidadpartida())).setScale(2,RoundingMode.HALF_UP)));
			}
			
			Cell celda339 = row6.createCell(9);
			celda339.setCellStyle(style);
			celda339.setCellValue(partida.getCertificacionaveria().getCertificacionaveriaobservacion());
			
			initRow6++;
			
			if (partida.getCertificacionaveria().getAveria().getZonal().toLowerCase().equals("lima")) {
				BigDecimal preciounitario= BigDecimal.valueOf(partida.getPartida().getTipobaremo().getTipobaremopreciolima()).multiply(BigDecimal.valueOf(Double.parseDouble(partida.getPartida().getPartidabaremo()))).setScale(2,RoundingMode.HALF_UP);
				BigDecimal preciopartida = preciounitario.multiply(BigDecimal.valueOf(partida.getCantidadpartida())).setScale(2,RoundingMode.HALF_UP);
				TotalBaremoporItem = TotalBaremoporItem + Double.parseDouble(String.valueOf(preciopartida));
			} else {
				BigDecimal preciounitario= BigDecimal.valueOf(partida.getPartida().getTipobaremo().getTipobaremoprecioprovincia()).multiply(BigDecimal.valueOf(Double.parseDouble(partida.getPartida().getPartidabaremo()))).setScale(2,RoundingMode.HALF_UP);
				BigDecimal preciopartida = preciounitario.multiply(BigDecimal.valueOf(partida.getCantidadpartida())).setScale(2,RoundingMode.HALF_UP);
				TotalBaremoporItem = TotalBaremoporItem + Double.parseDouble(String.valueOf(preciopartida));
			}
			
	        CantidadTotalporItem  = CantidadTotalporItem + partida.getCantidadpartida();
			}
			
			Row row101 = sheet6.createRow(initRow6+2);
			Cell cell101 = row101.createCell(3);
			cell101.setCellStyle(style);
			cell101.setCellValue(CantidadTotalporItem);
			Cell cell102 = row101.createCell(4);
			cell102.setCellStyle(style2);
			cell102.setCellValue("SUBTOTAL");
			Cell cell103 = row101.createCell(5);
			cell103.setCellStyle(style);
			cell103.setCellValue(0.00);
			//Cell cell104 = row101.createCell(7);
			//cell104.setCellStyle(style);
			//cell104.setCellValue(df.format(TotalBaremoporItem));
			Cell cell105 = row101.createCell(8);
			cell105.setCellStyle(style);
			cell105.setCellValue(df.format(TotalBaremoporItem));
			
			Row row106 = sheet6.createRow(initRow6+4);
			Cell cell106 = row106.createCell(7);
			cell106.setCellStyle(style2);
			cell106.setCellValue("Sub Total Servicios:");
			Cell cell107 = row106.createCell(8);
			cell107.setCellStyle(style);
			cell107.setCellValue("-");
			
			Row row108 = sheet6.createRow(initRow6+5);
			Cell cell108 = row108.createCell(7);
			cell108.setCellStyle(style2);
			cell108.setCellValue("Sub Total Materiales:");
			Cell cell109 = row108.createCell(8);
			cell109.setCellStyle(style);
			cell109.setCellValue("-");
			
			Row row110 = sheet6.createRow(initRow6+6);
			Cell cell111 = row110.createCell(7);
			cell111.setCellStyle(style2);
			cell111.setCellValue("Transporte - Desplaz.:");
			Cell cell112 = row110.createCell(8);
			cell112.setCellStyle(style);
			cell112.setCellValue("-");
			
			Row row113 = sheet6.createRow(initRow6+7);
			Cell cell114 = row113.createCell(7);
			cell114.setCellStyle(style2);
			cell114.setCellValue("Total Atencion:");
			Cell cell115 = row113.createCell(8);
			cell115.setCellStyle(style);
			cell115.setCellValue(df.format(TotalBaremoporItem));
			
			Row row116 = sheet6.createRow(initRow6+8);
			Cell cell117 = row116.createCell(7);
			cell117.setCellStyle(style2);
			cell117.setCellValue("Total (SIN IGV):");
			Cell cell118 = row116.createCell(8);
			cell118.setCellStyle(style);
			cell118.setCellValue(df.format(TotalBaremoporItem));
			
			sheet6.autoSizeColumn(0);
			sheet6.autoSizeColumn(1);
			sheet6.autoSizeColumn(2);
			sheet6.autoSizeColumn(3);
			sheet6.autoSizeColumn(4);
			sheet6.autoSizeColumn(5);
			sheet6.autoSizeColumn(6);
			sheet6.autoSizeColumn(7);
			sheet6.autoSizeColumn(8);
			sheet6.autoSizeColumn(9);

			//
			
		}
		
		else {
			if (idAveriaActual == partidacertificacionaveria.getCertificacionaveria().getAveria().getAveriaid()) {
				row.createCell(0).setCellValue("A" + String.format("%05d", itemActual));
			}
			
			else {
				itemActual = itemActual + 1;
				row.createCell(0).setCellValue("A" + String.format("%05d", itemActual));
				
				//DETALLES POR ITEM
				
				DecimalFormat df = new DecimalFormat("#.00");
				
				double TotalBaremoporItem = 0.00;
				int CantidadTotalporItem = 0;
				
				String[] columns6 = {"VALORIZACION DE SERVICIO"};

				Sheet sheet6 = workbook.createSheet("A" + String.format("%05d", itemActual));

				Row row6 = sheet6.createRow(0);
										
				for (int i = 0; i < columns6.length; i++) {
				Cell cell6 = row6.createCell(i);
				cell6.setCellStyle(style2);
				cell6.setCellValue(columns6[i]);
				}
				
				Row row61 = sheet6.createRow(2);
				Cell cell61 = row61.createCell(0);
				cell61.setCellStyle(style2);
				cell61.setCellValue("COBRA");
				Cell cell62 = row61.createCell(1);
				cell62.setCellStyle(style);
				cell62.setCellValue("A" + String.format("%05d", itemActual));
				
				Row row63 = sheet6.createRow(3);
				Cell cell64 = row63.createCell(0);
				cell64.setCellStyle(style2);
				cell64.setCellValue("INC");
				Cell cell65 = row63.createCell(1);
				cell65.setCellStyle(style);
				cell65.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getInc());
				
				Row row66 = sheet6.createRow(4);
				Cell cell67 = row66.createCell(0);
				cell67.setCellStyle(style2);
				cell67.setCellValue("SERVICIO");
				Cell cell68 = row66.createCell(1);
				cell68.setCellStyle(style);
				cell68.setCellValue("AVERIA");
				
				Row row69 = sheet6.createRow(5);
				Cell cell70 = row69.createCell(0);
				cell70.setCellStyle(style2);
				cell70.setCellValue("LUGAR");
				Cell cell71 = row69.createCell(1);
				cell71.setCellStyle(style);
				cell71.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getZonal());
				Cell cell72 = row69.createCell(6);
				cell72.setCellStyle(style2);
				cell72.setCellValue("GESTOR");
				Cell cell73 = row69.createCell(7);
				cell73.setCellStyle(style);
				cell73.setCellValue("SERVICE DESK-GICS");
				
				Row row74 = sheet6.createRow(6);
				Cell cell75 = row74.createCell(0);
				cell75.setCellStyle(style2);
				cell75.setCellValue("DIRECCION");
				Cell cell76 = row74.createCell(1);
				cell76.setCellStyle(style);
				cell76.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getDireccion());
				Cell cell77 = row74.createCell(6);
				cell77.setCellStyle(style2);
				cell77.setCellValue("VALIDA");
				Cell cell78 = row74.createCell(7);
				cell78.setCellStyle(style);
				cell78.setCellValue("");
				
				Row row79 = sheet6.createRow(7);
				Cell cell80 = row79.createCell(0);
				cell80.setCellStyle(style2);
				cell80.setCellValue("CD / DAS :");
				Cell cell81 = row79.createCell(1);
				cell81.setCellStyle(style);
				cell81.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getSisego());
				Cell cell82 = row79.createCell(6);
				cell82.setCellStyle(style2);
				cell82.setCellValue("INICIO :");
				Cell cell83 = row79.createCell(7);
				cell83.setCellStyle(style);
				cell83.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getFechaAtencion());
				
				Row row84 = sheet6.createRow(8);
				Cell cell85 = row84.createCell(0);
				cell85.setCellStyle(style2);
				cell85.setCellValue("CLIENTE :");
				Cell cell86 = row84.createCell(1);
				cell86.setCellStyle(style);
				cell86.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getObservaciones());
				Cell cell87 = row84.createCell(6);
				cell87.setCellStyle(style2);
				cell87.setCellValue("FINAL :");
				Cell cell88 = row84.createCell(7);
				cell88.setCellStyle(style);
				cell88.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getFechafinalizacion());
				
				String[] columns7 = {"Codigo", "Descripcion", "Unid", "Cant", "P. Unit", "TOTAL", "P. Unit", "", "TOTAL", "Tecnico"};

				Row row7 = sheet6.createRow(10);
										
				for (int i = 0; i < columns7.length; i++) {
				Cell cell7 = row7.createCell(i);
				cell7.setCellStyle(style2);
				cell7.setCellValue(columns7[i]);
				}
				
				Row row91 = sheet6.createRow(11);
				Cell cell91 = row91.createCell(0);
				cell91.setCellStyle(style);
				cell91.setCellValue("TRANSPORTE Y MANTENIMIENTO");
				
				Cell cell92 = row91.createCell(4);
				cell92.setCellStyle(style);
				cell92.setCellValue("SUMINISTRO");
				
				Cell cell93 = row91.createCell(6);
				cell93.setCellStyle(style);
				cell93.setCellValue("INSTALACION");
				
				String[] columns9 = {"Actividad - Resolución de Averías Circuitos de Datos"};

				Row row9 = sheet6.createRow(12);
										
				for (int i = 0; i < columns9.length; i++) {
				Cell cell9 = row9.createCell(i);
				cell9.setCellStyle(style);
				cell9.setCellValue(columns9[i]);
				}

				List<Partidacertificacionaveria> partidas6 = this.listarPartidasdeCertificacionaveria2(partidacertificacionaveria.getCertificacionaveria().getCertificacionaveriaid(), fechainicio, fechafin);
				int initRow6 = 13;
				for (Partidacertificacionaveria partida : partidas6) {
				row6 = sheet6.createRow(initRow6);

				Cell celda1 = row6.createCell(0);
				celda1.setCellStyle(style);
				celda1.setCellValue(partida.getPartida().getPartidaid());
				Cell celda2 = row6.createCell(1);
				celda2.setCellStyle(style);
				celda2.setCellValue(partida.getPartida().getPartidadescripcion());
				Cell celda3 = row6.createCell(2);
				celda3.setCellStyle(style);
				celda3.setCellValue(partida.getPartida().getPartidaum());
				Cell celda333 = row6.createCell(3);
				celda333.setCellStyle(style);
				celda333.setCellValue(partida.getCantidadpartida());
				Cell celda334 = row6.createCell(4);
				celda334.setCellStyle(style);
				celda334.setCellValue(0.00);
				Cell celda335 = row6.createCell(5);
				celda335.setCellStyle(style);
				celda335.setCellValue(0.00);
				

				if (partida.getCertificacionaveria().getAveria().getZonal().toLowerCase().equals("lima")) {
					
					Cell celda336 = row6.createCell(6);
					celda336.setCellStyle(style);
					celda336.setCellValue(df.format((partida.getPartida().getTipobaremo().getTipobaremopreciolima())*(Double.parseDouble(partida.getPartida().getPartidabaremo()))));
					//Cell celda337 = row6.createCell(7);
					//celda337.setCellStyle(style);
					//celda337.setCellValue(df.format((partida.getPartida().getTipobaremo().getTipobaremopreciolima())*(Double.parseDouble(partida.getPartida().getPartidabaremo()))));
					
					Cell celda338 = row6.createCell(8);
					celda338.setCellStyle(style);
					BigDecimal preciounitario= BigDecimal.valueOf(partida.getPartida().getTipobaremo().getTipobaremopreciolima()).multiply(BigDecimal.valueOf(Double.parseDouble(partida.getPartida().getPartidabaremo()))).setScale(2,RoundingMode.HALF_UP);
					celda338.setCellValue(String.valueOf(preciounitario.multiply(BigDecimal.valueOf(partida.getCantidadpartida())).setScale(2,RoundingMode.HALF_UP)));
					
				} else {
					
					Cell celda336 = row6.createCell(6);
					celda336.setCellStyle(style);
					celda336.setCellValue(df.format((partida.getPartida().getTipobaremo().getTipobaremoprecioprovincia())*(Double.parseDouble(partida.getPartida().getPartidabaremo()))));
					//Cell celda337 = row6.createCell(7);
					//celda337.setCellStyle(style);
					//celda337.setCellValue(Double.parseDouble(df.format((partida.getPartida().getTipobaremo().getTipobaremoprecioprovincia())*(Double.parseDouble(partida.getPartida().getPartidabaremo())))));
					Cell celda338 = row6.createCell(8);
					celda338.setCellStyle(style);
					BigDecimal preciounitario= BigDecimal.valueOf(partida.getPartida().getTipobaremo().getTipobaremoprecioprovincia()).multiply(BigDecimal.valueOf(Double.parseDouble(partida.getPartida().getPartidabaremo()))).setScale(2,RoundingMode.HALF_UP);
			
					celda338.setCellValue(String.valueOf(preciounitario.multiply(BigDecimal.valueOf(partida.getCantidadpartida())).setScale(2,RoundingMode.HALF_UP)));
				}
				
				Cell celda339 = row6.createCell(9);
				celda339.setCellStyle(style);
				celda339.setCellValue(partida.getCertificacionaveria().getCertificacionaveriaobservacion());
				
				initRow6++;
				
				if (partida.getCertificacionaveria().getAveria().getZonal().toLowerCase().equals("lima")) {
					BigDecimal preciounitario= BigDecimal.valueOf(partida.getPartida().getTipobaremo().getTipobaremopreciolima()).multiply(BigDecimal.valueOf(Double.parseDouble(partida.getPartida().getPartidabaremo()))).setScale(2,RoundingMode.HALF_UP);
					BigDecimal preciopartida = preciounitario.multiply(BigDecimal.valueOf(partida.getCantidadpartida())).setScale(2,RoundingMode.HALF_UP);
					TotalBaremoporItem = TotalBaremoporItem + Double.parseDouble(String.valueOf(preciopartida));
				} else {
					BigDecimal preciounitario= BigDecimal.valueOf(partida.getPartida().getTipobaremo().getTipobaremoprecioprovincia()).multiply(BigDecimal.valueOf(Double.parseDouble(partida.getPartida().getPartidabaremo()))).setScale(2,RoundingMode.HALF_UP);
					BigDecimal preciopartida = preciounitario.multiply(BigDecimal.valueOf(partida.getCantidadpartida())).setScale(2,RoundingMode.HALF_UP);
					TotalBaremoporItem = TotalBaremoporItem + Double.parseDouble(String.valueOf(preciopartida));
				}
				
				CantidadTotalporItem  = CantidadTotalporItem + partida.getCantidadpartida();
				}
				
				Row row101 = sheet6.createRow(initRow6+2);
				Cell cell101 = row101.createCell(3);
				cell101.setCellStyle(style);
				cell101.setCellValue(CantidadTotalporItem);
				Cell cell102 = row101.createCell(4);
				cell102.setCellStyle(style2);
				cell102.setCellValue("SUBTOTAL");
				Cell cell103 = row101.createCell(5);
				cell103.setCellStyle(style);
				cell103.setCellValue(0.00);
				//Cell cell104 = row101.createCell(7);
				//cell104.setCellStyle(style);
				//cell104.setCellValue(df.format(TotalBaremoporItem));
				Cell cell105 = row101.createCell(8);
				cell105.setCellStyle(style);
				cell105.setCellValue(df.format(TotalBaremoporItem));
				
				Row row106 = sheet6.createRow(initRow6+4);
				Cell cell106 = row106.createCell(7);
				cell106.setCellStyle(style2);
				cell106.setCellValue("Sub Total Servicios:");
				Cell cell107 = row106.createCell(8);
				cell107.setCellStyle(style);
				cell107.setCellValue("-");
				
				Row row108 = sheet6.createRow(initRow6+5);
				Cell cell108 = row108.createCell(7);
				cell108.setCellStyle(style2);
				cell108.setCellValue("Sub Total Materiales:");
				Cell cell109 = row108.createCell(8);
				cell109.setCellStyle(style);
				cell109.setCellValue("-");
				
				Row row110 = sheet6.createRow(initRow6+6);
				Cell cell111 = row110.createCell(7);
				cell111.setCellStyle(style2);
				cell111.setCellValue("Transporte - Desplaz.:");
				Cell cell112 = row110.createCell(8);
				cell112.setCellStyle(style);
				cell112.setCellValue("-");
				
				Row row113 = sheet6.createRow(initRow6+7);
				Cell cell114 = row113.createCell(7);
				cell114.setCellStyle(style2);
				cell114.setCellValue("Total Atencion:");
				Cell cell115 = row113.createCell(8);
				cell115.setCellStyle(style);
				cell115.setCellValue(df.format(TotalBaremoporItem));
				
				Row row116 = sheet6.createRow(initRow6+8);
				Cell cell117 = row116.createCell(7);
				cell117.setCellStyle(style2);
				cell117.setCellValue("Total (SIN IGV):");
				Cell cell118 = row116.createCell(8);
				cell118.setCellStyle(style);
				cell118.setCellValue(df.format(TotalBaremoporItem));
				
				sheet6.autoSizeColumn(0);
				sheet6.autoSizeColumn(1);
				sheet6.autoSizeColumn(2);
				sheet6.autoSizeColumn(3);
				sheet6.autoSizeColumn(4);
				sheet6.autoSizeColumn(5);
				sheet6.autoSizeColumn(6);
				sheet6.autoSizeColumn(7);
				sheet6.autoSizeColumn(8);
				sheet6.autoSizeColumn(9);

				//
				
			}
		}
		
		idAveriaActual = partidacertificacionaveria.getCertificacionaveria().getAveria().getAveriaid();
		
		Cell celdita1 = row.createCell(1);
		celdita1.setCellStyle(style);
		celdita1.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getFechaAtencion());
		Cell celdita2 = row.createCell(2);
		celdita2.setCellStyle(style);
		celdita2.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getFechafinalizacion());
		Cell celdita3 = row.createCell(3);
		celdita3.setCellStyle(style);
		celdita3.setCellValue("SERVICE DESK-GICS");
		Cell celdita4 = row.createCell(4);
		celdita4.setCellStyle(style);
		celdita4.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getSisego());
		Cell celdita5 = row.createCell(5);
		celdita5.setCellStyle(style);
		celdita5.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getZonal());
		Cell celdita6 = row.createCell(6);
		celdita6.setCellStyle(style);
		celdita6.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getDireccion());
		Cell celdita7 = row.createCell(7);
		celdita7.setCellStyle(style);
		celdita7.setCellValue("AVERIA");
		Cell celdita8 = row.createCell(8);
		celdita8.setCellStyle(style);
		celdita8.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getObservaciones());
		Cell celdita9 = row.createCell(9);
		celdita9.setCellStyle(style);
		celdita9.setCellValue(partidacertificacionaveria.getPartida().getPartidadescripcion());
		
		DecimalFormat df = new DecimalFormat("#.00");
		
		if (partidacertificacionaveria.getCertificacionaveria().getAveria().getZonal().toLowerCase().equals("lima")) {
			Cell celdita10 = row.createCell(10);
			celdita10.setCellStyle(style);
			celdita10.setCellValue(df.format((partidacertificacionaveria.getPartida().getTipobaremo().getTipobaremopreciolima())*(Double.parseDouble(partidacertificacionaveria.getPartida().getPartidabaremo()))));
		} else {
			Cell celdita10 = row.createCell(10);
			celdita10.setCellStyle(style);
			celdita10.setCellValue(df.format((partidacertificacionaveria.getPartida().getTipobaremo().getTipobaremoprecioprovincia())*(Double.parseDouble(partidacertificacionaveria.getPartida().getPartidabaremo()))));
		}
		
		//row.createCell(1).setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getFechaAtencion());
		//row.createCell(2).setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getFechafinalizacion());
		//row.createCell(3).setCellValue("SERVICE DESK-GICS");
		//row.createCell(4).setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getSisego());
		//row.createCell(5).setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getZonal());
		//row.createCell(6).setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getDireccion());
		//row.createCell(7).setCellValue("AVERIA");
		//row.createCell(8).setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getCliente());
		//row.createCell(9).setCellValue(partidacertificacionaveria.getPartida().getPartidadescripcion());
		
		//DecimalFormat df = new DecimalFormat("#.00");
		
		//if (partidacertificacionaveria.getCertificacionaveria().getAveria().getZonal().toLowerCase().equals("lima")) {
		//	row.createCell(10).setCellValue(Double.parseDouble(df.format((partidacertificacionaveria.getPartida().getTipobaremo().getTipobaremopreciolima())*(Double.parseDouble(partidacertificacionaveria.getPartida().getPartidabaremo())))));
		//} else {
		//	row.createCell(10).setCellValue(Double.parseDouble(df.format((partidacertificacionaveria.getPartida().getTipobaremo().getTipobaremoprecioprovincia())*(Double.parseDouble(partidacertificacionaveria.getPartida().getPartidabaremo())))));
		//}
		
		Cell celdita11 = row.createCell(11);
		celdita11.setCellStyle(style);
		celdita11.setCellValue(partidacertificacionaveria.getObservacionPartidacertificacionaveria());
		Cell celdita12 = row.createCell(12);
		celdita12.setCellStyle(style);
		celdita12.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getDepartamento());
		Cell celdita13 = row.createCell(13);
		celdita13.setCellStyle(style);
		celdita13.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getDistrito());
		Cell celdita14 = row.createCell(14);
		celdita14.setCellStyle(style);
		celdita14.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getSisego());
		Cell celdita15 = row.createCell(15);
		celdita15.setCellStyle(style);
		celdita15.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getInc());
		Cell celdita16 = row.createCell(16);
		celdita16.setCellStyle(style);
		celdita16.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getResponsable());
		Cell celdita17 = row.createCell(17);
		celdita17.setCellStyle(style);
		celdita17.setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getContrata());
		
		//row.createCell(11).setCellValue(partidacertificacionaveria.getObservacionPartidacertificacionaveria());
		//row.createCell(12).setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getDepartamento());
		//row.createCell(13).setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getDistrito());
		//row.createCell(14).setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getSisego());
		//row.createCell(15).setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getInc());
		//row.createCell(16).setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getResponsable());
		//row.createCell(17).setCellValue(partidacertificacionaveria.getCertificacionaveria().getAveria().getContrata());
		initRow++;
		}
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		sheet.autoSizeColumn(5);
		sheet.autoSizeColumn(6);
		sheet.autoSizeColumn(7);
		sheet.autoSizeColumn(8);
		sheet.autoSizeColumn(9);
		sheet.autoSizeColumn(10);
		sheet.autoSizeColumn(11);
		sheet.autoSizeColumn(12);
		sheet.autoSizeColumn(13);
		sheet.autoSizeColumn(14);
		sheet.autoSizeColumn(15);
		sheet.autoSizeColumn(16);
		sheet.autoSizeColumn(17);
		
		workbook.write(stream);
		workbook.close();
		
		return new ByteArrayInputStream(stream.toByteArray());
	}

	@Override
	public List<List<String>> listarCertificacionAverias(String fechainicio, String fechafin) {
		return (List<List<String>>) par.listarCertificacionAverias(fechainicio, fechafin);
	}

	@Override
	public List<List<String>> ListarPartidas() {
		return (List<List<String>>) par.ListarPartidas2();
	}

	@Override
	public List<Partidacertificacionaveria> listarPartidasdeCertificacionaveria2(int codigo, String fechainicio,
			String fechafin) {
		return (List<Partidacertificacionaveria>) par.listarPartidasdeCertificacionaveria2(codigo, fechainicio,
				fechafin);
	}

	@Override
	public List<Partidacertificacionaveria> listarPartidasdeCertificacionaveria3(String fechainicio, String fechafin) {
		return (List<Partidacertificacionaveria>) par.listarPartidasdeCertificacionaveria3(fechainicio, fechafin);
	}

	@Override
	public Partidacertificacionaveria buscarpartidacertificaionaveria(int codigo, int codigoaveria) {
		return par.buscarpartidacertificaionaveria(codigo, codigoaveria);
	}

	@Override
	public int actualizarpartidacertificaionaveria(int codigo, int codigoaveria) {
		return par.actualizarpartidacertificaionaveriacantidad(codigo, codigoaveria);
	}

}
