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

import com.example.demo.model.Strength;
import com.example.demo.service.StrengthService;

@Controller
@RequestMapping("/strength")
public class StrengthController {
	@Autowired
	private StrengthService strengthService;

	@GetMapping
	  public String strengthIndex(Model model) {
	    List<Strength> strengths = strengthService.findAll();
	    model.addAttribute("strengths", strengths);
	    return "strengthIndex";
	}

	@GetMapping("strengthNew")
	public String newStrength(Model model) {
		return "strengthNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Strength strength = strengthService.findOne(id);
		model.addAttribute("strength",strength);
		return "strengthEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Strength strength) {
		strengthService.save(strength);
		return "redirect:/strength";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Strength strength) {
        strength.setId(id);
        strengthService.save(strength);
        return "redirect:/strength";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        strengthService.delete(id);
        return "redirect:/strength";
    }
}