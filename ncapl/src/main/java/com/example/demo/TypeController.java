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

import com.example.demo.model.Type;
import com.example.demo.service.TypeService;

@Controller
@RequestMapping("/type")
public class TypeController {
	@Autowired
	private TypeService typeService;

	@GetMapping
	  public String typetIndex(Model model) {
	    List<Type> types = typeService.findAll();
	    model.addAttribute("types", types);
	    return "typeIndex";
	}

	@GetMapping("typeNew")
	public String newType(Model model) {
		return "typeNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Type type = typeService.findOne(id);
		model.addAttribute("type",type);
		return "typeEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Type type) {
		typeService.save(type);
		return "redirect:/type";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Type type) {
        type.setId(id);
        typeService.save(type);
        return "redirect:/type";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        typeService.delete(id);
        return "redirect:/plant";
    }
}