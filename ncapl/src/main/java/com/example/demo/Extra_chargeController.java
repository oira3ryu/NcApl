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

import com.example.demo.model.Extra_charge;
import com.example.demo.service.Extra_chargeService;

@Controller
@RequestMapping("/extra_charge")
public class Extra_chargeController {
	@Autowired
	private Extra_chargeService extra_chargeService;

	@GetMapping
	  public String extra_chargeIndex(Model model) {
	    List<Extra_charge> extra_charges = extra_chargeService.findAll();
	    model.addAttribute("extra_charges", extra_charges);
	    return "extra_chargeIndex";
	}

	@GetMapping("extra_chargeNew")
	public String newExtra_charge(Model model) {
		return "extra_chargeNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Extra_charge extra_charge = extra_chargeService.findOne(id);
		model.addAttribute("extra_charge",extra_charge);
		return "extra_chargeEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Extra_charge extra_charge) {
		extra_chargeService.save(extra_charge);
		return "redirect:/extra_charge";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Extra_charge extra_charge) {
        extra_charge.setId(id);
        extra_chargeService.save(extra_charge);
        return "redirect:/extra_charge";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        extra_chargeService.delete(id);
        return "redirect:/extra_charge";
    }
}