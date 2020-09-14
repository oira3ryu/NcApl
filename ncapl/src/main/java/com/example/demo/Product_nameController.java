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

import com.example.demo.model.Aggregate;
import com.example.demo.model.Book;
import com.example.demo.model.Company;
import com.example.demo.model.Composition;
import com.example.demo.model.Field;
import com.example.demo.model.Flg;
import com.example.demo.model.Journal;
import com.example.demo.model.Plant;
import com.example.demo.model.Product_name;
import com.example.demo.model.Slump;
import com.example.demo.model.Strength;
import com.example.demo.model.Type;
import com.example.demo.model.Unit;
import com.example.demo.service.AggregateService;
import com.example.demo.service.BookService;
import com.example.demo.service.CompanyService;
import com.example.demo.service.CompositionService;
import com.example.demo.service.FieldService;
import com.example.demo.service.FlgService;
import com.example.demo.service.JournalService;
import com.example.demo.service.PlantService;
import com.example.demo.service.Product_nameService;
import com.example.demo.service.SlumpService;
import com.example.demo.service.StrengthService;
import com.example.demo.service.TypeService;
import com.example.demo.service.UnitService;

@Controller
@RequestMapping("/product_name")
public class Product_nameController {

	@Autowired
	private Product_nameService product_nameService;

	@Autowired
	private BookService bookService;

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


	@GetMapping
	  public String product_nameIndex(Model model) {

		List<Product_name> product_names = product_nameService.findAll();
	    model.addAttribute("product_names",product_names);

	    List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		List<Journal> journals = journalService.findAll();
		model.addAttribute("journallist", journals);

		List<Strength> strengths = strengthService.findAll();
		model.addAttribute("strengthlist", strengths);

		List<Aggregate> aggregates = aggregateService.findAll();
		model.addAttribute("aggregatelist", aggregates);

		List<Slump> slumps = slumpService.findAll();
		model.addAttribute("slumplist", slumps);

		return "product_nameIndex";

	}

	@GetMapping("product_nameNew")
	public String newproduct_name(Model model) {

		List<Book> books = bookService.findAll();
		model.addAttribute("booklist", books);

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

		return "product_nameNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {

		Product_name product_name = product_nameService.findOne(id);
		model.addAttribute("product_name",product_name);

		List<Book> books = bookService.findAll();
		model.addAttribute("booklist", books);

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

		return "product_nameEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Product_name product_name) {
		product_nameService.save(product_name);
		return "redirect:/product_name";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Product_name product_name) {
        product_name.setPn_id(id);
        product_nameService.save(product_name);
        return "redirect:/product_name";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        product_nameService.delete(id);
        return "redirect:/product_name";
    }
}