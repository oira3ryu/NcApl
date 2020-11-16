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

import com.example.demo.model.Other_charge;
import com.example.demo.service.Other_chargeService;

@Controller
@RequestMapping("/other_charge")
public class Other_chargeController {
	@Autowired
	private Other_chargeService other_chargeService;

	@GetMapping
	  public String other_chargeIndex(Model model) {
	    List<Other_charge> other_charges = other_chargeService.findAll();
	    model.addAttribute("other_charges", other_charges);
	    return "other_chargeIndex";
	}

	@GetMapping("other_chargeNew")
	public String newOther_charge(Model model) {
		return "other_chargeNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Other_charge other_charge = other_chargeService.findOne(id);
		model.addAttribute("other_charge",other_charge);
		return "other_chargeEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Other_charge other_charge) {
		other_chargeService.save(other_charge);
		return "redirect:/other_charge";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Other_charge other_charge) {
        other_charge.setId(id);
        other_chargeService.save(other_charge);
        return "redirect:/other_charge";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        other_chargeService.delete(id);
        return "redirect:/other_charge";
    }
}