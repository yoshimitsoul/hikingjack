package com.rando.controleur;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Controller
@RequestMapping("/admin")
public class RapportController {
	
	@Autowired
	private DataSource dataSource;
	
	private JasperReport rapport;
	
	 @PostConstruct
	  public void compilerRapport() throws Exception {
	    InputStream modeleInputStream = this.getClass().getResourceAsStream("/etape_rando.jrxml");
	    rapport = JasperCompileManager.compileReport(modeleInputStream);
	  }
	
	  @GetMapping(path="/generation-rapport-etape.pdf", produces = "application/pdf")
	  public void produireRapport(OutputStream out, HttpServletResponse response, HttpSession httpSession, int idEtape) throws Exception {
		  

	    try(Connection connection = dataSource.getConnection()) {
	      Map<String, Object> parameters = new HashMap<>();
	      parameters.put("idEtape", idEtape);
	      JasperPrint print = JasperFillManager.fillReport(rapport, parameters, connection);

	      JRPdfExporter pdfExporter = new JRPdfExporter();
	      pdfExporter.setExporterInput(new SimpleExporterInput(print));
         ByteArrayOutputStream pdfReportStream = new ByteArrayOutputStream();
         pdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfReportStream));
         pdfExporter.exportReport();

         response.setContentType("application/pdf");
         response.setHeader("Content-Length", String.valueOf(pdfReportStream.size()));
         response.addHeader("Content-Disposition", "inline; filename=jasper.pdf;");

         OutputStream responseOutputStream = response.getOutputStream();
         responseOutputStream.write(pdfReportStream.toByteArray());
         responseOutputStream.close();
         pdfReportStream.close();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	  }
}
