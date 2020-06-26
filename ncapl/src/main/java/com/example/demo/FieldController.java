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

import com.example.demo.model.Field;
import com.example.demo.service.FieldService;

@Controller
@RequestMapping("/field")
public class FieldController {
	@Autowired
	private FieldService fieldService;

	@GetMapping
	  public String fieldIndex(Model model) {
	    List<Field> fields = fieldService.findAll();
	    model.addAttribute("fields", fields);
	    return "fieldIndex";
	}

	@GetMapping("fieldNew")
	public String newField(Model model) {
		return "fieldNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Field field = fieldService.findOne(id);
		model.addAttribute("field",field);
		return "fieldEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Field field) {
		fieldService.save(field);
		return "redirect:/field";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Field field) {
        field.setId(id);
        fieldService.save(field);
        return "redirect:/field";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        fieldService.delete(id);
        return "redirect:/field";
    }
}