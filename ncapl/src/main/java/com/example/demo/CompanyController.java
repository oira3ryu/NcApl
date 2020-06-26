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
import com.example.demo.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@GetMapping
	  public String companyIndex(Model model) {
	    List<Company> companys = companyService.findAll();
	    model.addAttribute("companys", companys);
	    return "companyIndex";
	}

	@GetMapping("companyNew")
	public String newCompany(Model model) {
		return "companyNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Company company = companyService.findOne(id);
		model.addAttribute("company",company);
		return "companyEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Company company) {
		companyService.save(company);
		return "redirect:/company";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Company company) {
        company.setId(id);
        companyService.save(company);
        return "redirect:/company";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        companyService.delete(id);
        return "redirect:/company";
    }
}