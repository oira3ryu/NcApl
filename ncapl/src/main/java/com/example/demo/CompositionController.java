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

import com.example.demo.model.Composition;
import com.example.demo.service.CompositionService;

@Controller
@RequestMapping("/composition")
public class CompositionController {
	@Autowired
	private CompositionService compositionService;

	@GetMapping
	  public String compositionIndex(Model model) {
	    List<Composition> compositions = compositionService.findAll();
	    model.addAttribute("compositions", compositions);
	    return "compositionIndex";
	}

	@GetMapping("compositionNew")
	public String newComposition(Model model) {
		return "compositionNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Composition composition = compositionService.findOne(id);
		model.addAttribute("composition",composition);
		return "compositionEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Composition composition) {
		compositionService.save(composition);
		return "redirect:/composition";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Composition composition) {
        composition.setId(id);
        compositionService.save(composition);
        return "redirect:/composition";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        compositionService.delete(id);
        return "redirect:/composition";
    }
}