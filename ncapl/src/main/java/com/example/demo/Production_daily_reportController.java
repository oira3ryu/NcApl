package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Company;
import com.example.demo.model.Composition;
import com.example.demo.model.Field;
import com.example.demo.model.Flg;
import com.example.demo.model.Journal;
import com.example.demo.model.Plant;
import com.example.demo.model.Product_name;
import com.example.demo.model.Production_daily_report;
import com.example.demo.model.Type;
import com.example.demo.model.Unit;
import com.example.demo.service.CompanyService;
import com.example.demo.service.CompositionService;
import com.example.demo.service.FieldService;
import com.example.demo.service.FlgService;
import com.example.demo.service.JournalService;
import com.example.demo.service.PlantService;
import com.example.demo.service.Product_nameService;
import com.example.demo.service.Production_daily_reportService;
import com.example.demo.service.TypeService;
import com.example.demo.service.UnitService;

@Controller
@RequestMapping("/production_daily_report")
public class Production_daily_reportController {

	@Autowired
	private Production_daily_reportService production_daily_reportService;

	@Autowired
	private PlantService plantService;

	@Autowired
	private Product_nameService product_nameService;

	@Autowired
	private JournalService journalService;

	@Autowired
	private CompositionService compositionService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private FieldService fieldService;

	@Autowired
	private FlgService flgService;

	@Autowired
	private TypeService typeService;

	@Autowired
	private UnitService unitService;


	@GetMapping
	  public String production_daily_reportIndex(Model model) {

	    List<Production_daily_report> production_daily_reports = production_daily_reportService.findAll();
	    model.addAttribute("production_daily_reports",production_daily_reports);

		List<Plant> plants = plantService.findAll();
		model.addAttribute("plantlist", plants);

	    List<Product_name> product_names = product_nameService.findAll();
	    model.addAttribute("product_namelist", product_names);

		List<Company> companys = companyService.findAll();
		model.addAttribute("companylist", companys);

		List<Field> fields = fieldService.findAll();
		model.addAttribute("fieldlist", fields);

	    return "production_daily_reportIndex";
	}

	@GetMapping("production_daily_reportNew")
	public String newproduction_daily_report(Model model) {

		List<Plant> plants = plantService.findAll();
		model.addAttribute("plantlist", plants);

	    List<Product_name> product_names = product_nameService.findAll();
	    model.addAttribute("product_namelist", product_names);

		List<Journal> journals = journalService.findAll();
		model.addAttribute("journallist", journals);

		List<Composition> compositions = compositionService.findAll();
		model.addAttribute("compositionlist", compositions);

		List<Company> companys = companyService.findAll();
		model.addAttribute("companylist", companys);

		List<Field> fields = fieldService.findAll();
		model.addAttribute("fieldlist", fields);

		List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		List<Type> types = typeService.findAll();
		model.addAttribute("typelist", types);

		List<Unit> units = unitService.findAll();
		model.addAttribute("unitlist", units);

		return "production_daily_reportNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Production_daily_report production_daily_report = production_daily_reportService.findOne(id);
		model.addAttribute("production_daily_report",production_daily_report);

		List<Plant> plants = plantService.findAll();
		model.addAttribute("plantlist", plants);

	    List<Product_name> product_names = product_nameService.findAll();
	    model.addAttribute("product_namelist", product_names);

		List<Journal> journals = journalService.findAll();
		model.addAttribute("journallist", journals);

		List<Composition> compositions = compositionService.findAll();
		model.addAttribute("compositionlist", compositions);

		List<Company> companys = companyService.findAll();
		model.addAttribute("companylist", companys);

		List<Field> fields = fieldService.findAll();
		model.addAttribute("fieldlist", fields);

		List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		List<Type> types = typeService.findAll();
		model.addAttribute("typelist", types);

		List<Unit> units = unitService.findAll();
		model.addAttribute("unitlist", units);

		return "production_daily_reportEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Production_daily_report production_daily_report) {
		production_daily_reportService.save(production_daily_report);
		return "redirect:/production_daily_report";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Production_daily_report production_daily_report) {
        production_daily_report.setPdr_id(id);
        production_daily_reportService.save(production_daily_report);
        return "redirect:/production_daily_report";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        production_daily_reportService.delete(id);
        return "redirect:/production_daily_report";
    }
}