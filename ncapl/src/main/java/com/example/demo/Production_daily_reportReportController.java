package com.example.demo;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Production_daily_report_view;
import com.example.demo.service.Production_daily_report_viewService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
public class Production_daily_reportReportController {

	@Autowired
    ApplicationContext context;

	@Autowired
	Production_daily_report_viewService production_daily_report_viewService;

	@GetMapping(path = "production_daily_report/{jrxml}/{coid}/{fiid}/{recorddate}")
	@ResponseBody
    public void getPdf(
            @PathVariable String jrxml,
            @PathVariable String coid,
            @PathVariable String fiid,
            @PathVariable String recorddate,
            HttpServletResponse response) throws Exception {

		//Get JRXML template from resources folder
		Resource resource = context.getResource("classpath:jasperreports/"+jrxml+".jrxml");

		//Compile to jasperReport
        InputStream inputStream = resource.getInputStream();
        JasperReport report=JasperCompileManager.compileReport(inputStream);

        //Parameters Set
//        Map<String, Object> params = new HashMap<>();
        Map<String, Object> params = getParams();

        Production_daily_report_view param = new Production_daily_report_view();
        if (!StringUtils.isEmpty(coid)) {
            try {
                param.setCoid(Integer.valueOf(coid));
            } catch (Exception e) {
                // エラーは握り潰す
            }
        }
        if (!StringUtils.isEmpty(fiid)) {
            try {
                param.setFiid(Integer.valueOf(fiid));
            } catch (Exception e) {
                // エラーは握り潰す
            }
        }
        if (!StringUtils.isEmpty(recorddate)) {
            try {
                param.setRecorddate((recorddate));
            } catch (Exception e) {
                // エラーは握り潰す
            }
        }

        List<Production_daily_report_view> source = production_daily_report_viewService.findByForm(param);

        //Data source Set
        JasperPrint print = JasperFillManager.fillReport(report, params, new JRBeanCollectionDataSource(source));

        //Media Type
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-Disposition", "inline;");
        //Export PDF Stream
        JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
    }
    /**
     * PDF出力の際に使用するパラメータを取得
     *
     * @return
     */
    private static Map<String, Object> getParams() {
        Map<String, Object> params = new HashMap<>();

//        params.put("coid", new Integer(2));
//        params.put("amount", new BigDecimal(1000000));
//        params.put("remarks", "保守費用");
//        params.put("paymentDate", new Date());
//        params.put("paymentTypeName", "現金");

        return params;
    }
}
