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

import com.example.demo.model.Tax;
import com.example.demo.service.TaxService;

@Controller
@RequestMapping("/tax")
public class TaxController {
	@Autowired
	private TaxService taxService;

	@GetMapping
	  public String taxtIndex(Model model) {
	    List<Tax> taxs = taxService.findAll();
	    model.addAttribute("taxs", taxs);
	    return "taxIndex";
	}

	@GetMapping("taxNew")
	public String newTax(Model model) {
		return "taxNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Tax tax = taxService.findOne(id);
		model.addAttribute("tax",tax);
		return "taxEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Tax tax) {
		taxService.save(tax);
		return "redirect:/tax";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Tax tax) {
        tax.setId(id);
        taxService.save(tax);
        return "redirect:/tax";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        taxService.delete(id);
        return "redirect:/plant";
    }
}