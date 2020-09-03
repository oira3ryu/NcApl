package com.example.demo;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Field;
import com.example.demo.service.FieldService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
public class FieldReportController {

	@Autowired
    ApplicationContext context;

	@Autowired
	FieldService fieldService;

	@GetMapping(path = "field/{jrxml}")
	@ResponseBody
    public void getPdf(@PathVariable String jrxml ,HttpServletResponse response) throws Exception {

		//Get JRXML template from resources folder
		Resource resource = context.getResource("classpath:jasperreports/"+jrxml+".jrxml");

		//Compile to jasperReport
        InputStream inputStream = resource.getInputStream();
        JasperReport report=JasperCompileManager.compileReport(inputStream);

        //Parameters Set
        Map<String, Object> params = new HashMap<>();

        List<Field> source = fieldService.findAll();

        //Data source Set
        JasperPrint print = JasperFillManager.fillReport(report, params, new JRBeanCollectionDataSource(source));

        //Media Type
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-Disposition", "inline;");
        //Export PDF Stream
        JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
    }
}
