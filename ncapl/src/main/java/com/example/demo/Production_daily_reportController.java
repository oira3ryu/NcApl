package com.example.demo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.DailyreportSearchForm;
import com.example.demo.model.Aggregate;
import com.example.demo.model.Company;
import com.example.demo.model.Composition;
import com.example.demo.model.Ex_works;
import com.example.demo.model.Field;
import com.example.demo.model.Flg;
import com.example.demo.model.Journal;
import com.example.demo.model.Plant;
import com.example.demo.model.Product_name;
import com.example.demo.model.Product_name_view;
import com.example.demo.model.Product_name_view_jid;
import com.example.demo.model.Product_sales;
import com.example.demo.model.Production_daily_report;
import com.example.demo.model.Production_daily_report_view;
import com.example.demo.model.Pump;
import com.example.demo.model.Slump;
import com.example.demo.model.Strength;
import com.example.demo.model.Type;
import com.example.demo.model.Unit;
import com.example.demo.service.AggregateService;
import com.example.demo.service.CompanyService;
import com.example.demo.service.CompositionService;
import com.example.demo.service.Ex_worksService;
import com.example.demo.service.FieldService;
import com.example.demo.service.FlgService;
import com.example.demo.service.JournalService;
import com.example.demo.service.PlantService;
import com.example.demo.service.Product_nameService;
import com.example.demo.service.Product_name_viewService;
import com.example.demo.service.Product_name_view_jidService;
import com.example.demo.service.Product_salesService;
import com.example.demo.service.Production_daily_reportService;
import com.example.demo.service.Production_daily_report_viewService;
import com.example.demo.service.PumpService;
import com.example.demo.service.SlumpService;
import com.example.demo.service.StrengthService;
import com.example.demo.service.TypeService;
import com.example.demo.service.UnitService;

@Controller
@RequestMapping("/production_daily_report")
public class Production_daily_reportController {

	@Autowired
	private Production_daily_reportService production_daily_reportService;

	@Autowired
	private Production_daily_report_viewService production_daily_report_viewService;

	@Autowired
	private Product_name_view_jidService product_name_view_jidService;

	@Autowired
	private Product_nameService product_nameService;

	@Autowired
	private Product_name_viewService product_name_viewService;

	@Autowired
	private PlantService plantService;

	@Autowired
	private JournalService journalService;

	@Autowired
	private StrengthService strengthService;

	@Autowired
	private AggregateService aggregateService;

	@Autowired
	private CompositionService compositionService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private FieldService fieldService;

	@Autowired
	private FlgService flgService;

	@Autowired
	private SlumpService slumpService;

	@Autowired
	private TypeService typeService;

	@Autowired
	private UnitService unitService;

	@Autowired
	private PumpService pumpService;

	@Autowired
	private Product_salesService product_salesService;

	@Autowired
	private Ex_worksService ex_worksService;

	@GetMapping
	  public String production_daily_reportIndex(Model model) {

	    List<Production_daily_report> production_daily_reports = production_daily_reportService.findAll();
	    model.addAttribute("production_daily_reportlist",production_daily_reports);

	    List<Production_daily_report_view> production_daily_report_views = production_daily_report_viewService.findAll();
	    model.addAttribute("production_daily_report_viewlist",production_daily_report_views);

	    List<Product_name> product_names = product_nameService.findAll();
		model.addAttribute("product_namelist", product_names);

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

	    List<Plant> plants = plantService.findAll();
		model.addAttribute("plantlist", plants);

		List<Company> companys = companyService.findAll();
		model.addAttribute("companylist", companys);

		List<Field> fields = fieldService.findAll();
		model.addAttribute("fieldlist", fields);

		List<Strength> strengths = strengthService.findAll();
		model.addAttribute("strengthlist", strengths);

		List<Aggregate> aggregates = aggregateService.findAll();
		model.addAttribute("aggregatelist", aggregates);

		List<Slump> slumps = slumpService.findAll();
		model.addAttribute("slumplist", slumps);

	    List<Pump> pumps = pumpService.findAll();
		model.addAttribute("pumplist", pumps);

		List<Product_sales> product_saless = product_salesService.findAll();
		model.addAttribute("product_saleslist", product_saless);

		List<Ex_works> ex_workss = ex_worksService.findAll();
		model.addAttribute("ex_workslist", ex_workss);

		model.addAttribute("searchParam", new DailyreportSearchForm());

	    return "production_daily_reportIndex";
	}

	@GetMapping("production_daily_reportNew")
	public String newproduction_daily_report(Model model) {

		List<Product_name> product_names = product_nameService.findAll();
		model.addAttribute("product_namelist", product_names);

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

		List<Product_name_view_jid> product_name_view_jids = product_name_view_jidService.findAll();
		model.addAttribute("product_name_view_jidlist", product_name_view_jids);

		List<Plant> plants = plantService.findAll();
		model.addAttribute("plantlist", plants);

		List<Journal> journals = journalService.findAll();
		model.addAttribute("journallist", journals);

		List<Strength> strengths = strengthService.findAll();
		model.addAttribute("strengthlist", strengths);

		List<Aggregate> aggregates = aggregateService.findAll();
		model.addAttribute("aggregatelist", aggregates);

		List<Composition> compositions = compositionService.findAll();
		model.addAttribute("compositionlist", compositions);

		List<Company> companys = companyService.findAll();
		model.addAttribute("companylist", companys);

		List<Field> fields = fieldService.findAll();
		model.addAttribute("fieldlist", fields);

		List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		List<Slump> slumps = slumpService.findAll();
		model.addAttribute("slumplist", slumps);

		List<Type> types = typeService.findAll();
		model.addAttribute("typelist", types);

		List<Unit> units = unitService.findAll();
		model.addAttribute("unitlist", units);

	    List<Pump> pumps = pumpService.findAll();
		model.addAttribute("pumplist", pumps);

		List<Product_sales> product_saless = product_salesService.findAll();
		model.addAttribute("product_saleslist", product_saless);

		List<Ex_works> ex_workss = ex_worksService.findAll();
		model.addAttribute("ex_workslist", ex_workss);

		return "production_daily_reportNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id, Model model) {

		Production_daily_report production_daily_reports = production_daily_reportService.findOne(id);
		model.addAttribute("production_daily_reportlist",production_daily_reports);

		List<Product_name> product_names = product_nameService.findAll();
		model.addAttribute("product_namelist", product_names);

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

		List<Plant> plants = plantService.findAll();
		model.addAttribute("plantlist", plants);

		List<Journal> journals = journalService.findAll();
		model.addAttribute("journallist", journals);

		List<Strength> strengths = strengthService.findAll();
		model.addAttribute("strengthlist", strengths);

		List<Aggregate> aggregates = aggregateService.findAll();
		model.addAttribute("aggregatelist", aggregates);

		List<Composition> compositions = compositionService.findAll();
		model.addAttribute("compositionlist", compositions);

		List<Company> companys = companyService.findAll();
		model.addAttribute("companylist", companys);

		List<Field> fields = fieldService.findAll();
		model.addAttribute("fieldlist", fields);

		List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		List<Slump> slumps = slumpService.findAll();
		model.addAttribute("slumplist", slumps);

		List<Type> types = typeService.findAll();
		model.addAttribute("typelist", types);

		List<Unit> units = unitService.findAll();
		model.addAttribute("unitlist", units);

	    List<Pump> pumps = pumpService.findAll();
		model.addAttribute("pumplist", pumps);

		List<Product_sales> product_saless = product_salesService.findAll();
		model.addAttribute("product_saleslist", product_saless);

		List<Ex_works> ex_workss = ex_worksService.findAll();
		model.addAttribute("ex_workslist", ex_workss);

		return "production_daily_reportEdit";
	}

    @PostMapping("search")
    public String search(@ModelAttribute("searchParam") DailyreportSearchForm form, Model model) {

    	if (StringUtils.isBlank(form.getRecorddate())) {
    		form.setRecorddate(null);
    	}

    	if (StringUtils.isBlank(form.getRecorddateEnd())) {
    		form.setRecorddateEnd(null);
    	}

        List<Production_daily_report> production_daily_reports =
                production_daily_reportService.findByForm(form);
        model.addAttribute("production_daily_reportlist",production_daily_reports);

	    List<Production_daily_report_view> production_daily_report_views = production_daily_report_viewService.findAll();
	    model.addAttribute("production_daily_report_viewlist",production_daily_report_views);

        List<Product_name> product_names = product_nameService.findAll();
		model.addAttribute("product_namelist", product_names);

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

        List<Plant> plants = plantService.findAll();
        model.addAttribute("plantlist", plants);

        List<Company> companys = companyService.findAll();
        model.addAttribute("companylist", companys);

        List<Field> fields = fieldService.findAll();
        model.addAttribute("fieldlist", fields);

        List<Strength> strengths = strengthService.findAll();
        model.addAttribute("strengthlist", strengths);

        List<Aggregate> aggregates = aggregateService.findAll();
        model.addAttribute("aggregatelist", aggregates);

        List<Slump> slumps = slumpService.findAll();
        model.addAttribute("slumplist", slumps);

	    List<Pump> pumps = pumpService.findAll();
		model.addAttribute("pumplist", pumps);

		List<Product_sales> product_saless = product_salesService.findAll();
		model.addAttribute("product_saleslist", product_saless);

		List<Ex_works> ex_workss = ex_worksService.findAll();
		model.addAttribute("ex_workslist", ex_workss);

        model.addAttribute("searchParam", form);

        return "production_daily_reportIndex";
    }

	@PostMapping
	public String create(@ModelAttribute Production_daily_report production_daily_report) {
		production_daily_reportService.save(production_daily_report);
		return "redirect:/production_daily_report";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Production_daily_report production_daily_report) {
        production_daily_report.setPdrid(id);
        production_daily_reportService.save(production_daily_report);
        return "redirect:/production_daily_report";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        production_daily_reportService.delete(id);
        return "redirect:/production_daily_report";
    }
}