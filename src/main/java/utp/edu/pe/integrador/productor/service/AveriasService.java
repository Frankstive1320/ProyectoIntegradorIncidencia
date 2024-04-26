package utp.edu.pe.integrador.productor.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utp.edu.pe.integrador.productor.interfaces.IAverias;
import utp.edu.pe.integrador.productor.interfacesservice.IAveriasService;
import utp.edu.pe.integrador.productor.model.Averias;


@Service
public class AveriasService implements IAveriasService {
	
	@Autowired
	private IAverias averias1;

	
	@Override
	public List<Averias> listarAveria() {
		// TODO Auto-generated method stub
		return (List<Averias>) averias1.findAll();
	}
	@Override
	public int grabarAverias(Averias pAverias) {
		// TODO Auto-generated method stub
		int res=0;		
		Averias averias = averias1.save(pAverias);
		if (!averias.equals(null)) {
			res=1;
		}
		return res;
	}
	@Override
	public Averias averiaPorCodigo(int cod) {
		// TODO Auto-generated method stub
		return averias1.findById(cod).orElse(null);
	}	
	@Override
	public void eliminarAverias(int cod) {
		// TODO Auto-generated method stub	
		averias1.deleteById(cod);
	}
	@Override
	public List<Averias> listaraveriasenplanta() {
		// TODO Auto-generated method stub
		return (List<Averias>) averias1.listaraveriasenplanta();
	}
	@Override
	public List<Averias> listaraveriasenplanta2() {
		return (List<Averias>) averias1.listaraveriasenplanta2();
	}
	@Override
	public List<Averias> listarAveriasEjecutasMateriales(String contrata) {
		return (List<Averias>) averias1.listarAveriasEjecutasMateriales(contrata);
	}
	@Override
	public List<Averias> listarAveriasEjecutasMateriales2() {
		return (List<Averias>) averias1.listarAveriasEjecutasMateriales2();
	}
	@Override
	public void ActualizarAveriaLiquidacion(int averiaid) {
		averias1.ActualizarAveriaLiquidacion(averiaid);
	}
	@Override
	public List<Averias> listarAveriasSinCertificacion(String contrata) {
		return (List<Averias>) averias1.listarAveriasSinCertificacion(contrata);
	}
	@Override
	public void ActualizarAveriaSinCertificacion(int averiaid) {
		averias1.ActualizarAveriaSinCertificacion(averiaid);
	}
	@Override
	public void ActualizarAveriaFechaFinalizacionn(String fechafinalizacion, int averiaid) {
		averias1.ActualizarAveriaFechaFinalizacionn(fechafinalizacion, averiaid);
	}
	@Override
	public List<Averias> listarAveriasportecnico(String contrata) {
		return (List<Averias>) averias1.listarAveriasportecnico(contrata);
	}
	@Override
	public ByteArrayInputStream exportAllDta() throws Exception {
		// TODO Auto-generated method stub
		
		
		String[] columns = {"INC","SISEGO","ZONAL","ZONIFICACION","CONTRATA","TECNICO ASIGNADO", "FECHA ATENCION",
				"TIPO AVERIA","DIAGNOSTICO","PARADA DE RELOJ","ACCIONES CORRECTIVAS","ESTADO","OBSERVACIONES"
				,"CLIENTES","MATERIALES"};
				Workbook workbook = new HSSFWorkbook();
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				Sheet sheet = workbook.createSheet("AVERIAS");
				
						Font font1 = workbook.createFont();  
				font1.setBold(true);
				font1.setColor(IndexedColors.BLACK.index);
				
				
				CellStyle style5 = workbook.createCellStyle();
				style5.setBorderBottom(BorderStyle.THIN);
				style5.setBorderTop(BorderStyle.THIN);
				style5.setBorderRight(BorderStyle.THIN);
				style5.setBorderLeft(BorderStyle.THIN);
				style5.setAlignment(HorizontalAlignment.CENTER);
				style5.setFont(font1);
				
				CellStyle style = workbook.createCellStyle();
				style.setBorderBottom(BorderStyle.THIN);
				style.setBorderTop(BorderStyle.THIN);
				style.setBorderRight(BorderStyle.THIN);
				style.setBorderLeft(BorderStyle.THIN);
				style.setAlignment(HorizontalAlignment.CENTER);
				
				Font font = workbook.createFont();  
				font.setBold(true);
				font.setColor(IndexedColors.WHITE.index);
				
				CellStyle style1 = workbook.createCellStyle();
				style1.setFillForegroundColor(IndexedColors.ROYAL_BLUE.index);
				style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				style1.setBorderBottom(BorderStyle.THIN);
				style1.setBorderTop(BorderStyle.THIN);
				style1.setBorderRight(BorderStyle.THIN);
				style1.setBorderLeft(BorderStyle.THIN);
				style1.setAlignment(HorizontalAlignment.CENTER);
				style1.setFont(font);
				
				CellStyle style2 = workbook.createCellStyle();
				style2.setFillForegroundColor(IndexedColors.DARK_BLUE.index);
				style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				style2.setBorderBottom(BorderStyle.THIN);
				style2.setBorderTop(BorderStyle.THIN);
				style2.setBorderRight(BorderStyle.THIN);
				style2.setBorderLeft(BorderStyle.THIN);
				style2.setAlignment(HorizontalAlignment.CENTER);
				style2.setFont(font);
				
				
				

			
				Row row = sheet.createRow(0);
				
				for (int i = 0; i < columns.length; i++) {
				Cell cell = row.createCell(i);
				cell.setCellStyle(style2);
				cell.setCellValue(columns[i]);
				}
				List<Averias> averia = this.listarAveria();
				int initRow = 1;
				
				for (Averias averiast : averia) {
				row = sheet.createRow(initRow);
				
				row.createCell(0).setCellValue(averiast.getInc());
				row.createCell(1).setCellValue(averiast.getSisego());
				row.createCell(2).setCellValue(averiast.getZonal());
				row.createCell(3).setCellValue(averiast.getZonificacion());
				row.createCell(4).setCellValue(averiast.getContrata());
				row.createCell(5).setCellValue(averiast.getTecnicoAsignado());
				row.createCell(6).setCellValue(averiast.getFechaAtencion());
				row.createCell(7).setCellValue(averiast.getTipoAveria());
				row.createCell(8).setCellValue(averiast.getDiagnostico());
				row.createCell(9).setCellValue(averiast.getParadaReloj());
				row.createCell(10).setCellValue(averiast.getAccionesCorrectivas());
				row.createCell(11).setCellValue(averiast.getEstado());
				row.createCell(12).setCellValue(averiast.getCliente());
				row.createCell(13).setCellValue(averiast.getObservaciones());
				row.createCell(14).setCellValue(averiast.getMateriales());
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
				workbook.write(stream);
				workbook.close();
				
				return new ByteArrayInputStream(stream.toByteArray());
		}
	

}
