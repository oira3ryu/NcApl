package com.example.demo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Flg;
import com.example.demo.repository.FlgRepository;
import com.example.demo.service.FlgService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
public class FlgReportController {

	@Autowired
    ApplicationContext context;

	@Autowired
	FlgRepository repository;
	@Autowired
	private FlgService flgService;

	@GetMapping
	  public String flgIndex(Model model) {
	    List<Flg> flgs = flgService.findAll();
	    model.addAttribute("flgs", flgs);
	    return "flgIndex";
	}

	@GetMapping(path = "pdf/{jrxml}")
	@ResponseBody
    public void getPdf(@PathVariable String jrxml ,HttpServletResponse response,HttpServletRequest request) throws Exception {
		//Get JRXML template from resources folder
		Resource resource = context.getResource("classpath:jasperreports/"+jrxml+".jrxml");
        //Compile to jasperReport
        InputStream inputStream = resource.getInputStream();
        JasperReport report=JasperCompileManager.compileReport(inputStream);

        List<Flg> source = new ArrayList<Flg>();
        //Parameters Set
        Map<String, Object> params = new HashMap<>();

//        Collection<Map<String, ?>> source = new ArrayList<>();
//
//        Map<String, Object> row1 = new HashMap<>();
//        row1.put("id", 1);
//        row1.put("value", "100");
//        source.add(row1);
//        Map<String, Object> row2 = new HashMap<>();
//        row2.put("id", 2);
//        row2.put("value", "200");
//        source.add(row2);
//        Map<String, Object> row3 = new HashMap<>();
//        row3.put("id", 3);
//        row3.put("value", "300");
//        source.add(row3);

        //Data source Set
        //JRDataSource dataSource = new JREmptyDataSource();
        JasperPrint print = JasperFillManager.fillReport(report, params, new JRBeanCollectionDataSource(source));
        //Make jasperPrint
        //JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, source);
        //Media Type
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        //Export PDF Stream
        JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
    }
}
