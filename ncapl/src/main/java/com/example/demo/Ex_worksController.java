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

import com.example.demo.model.Ex_works;
import com.example.demo.service.Ex_worksService;

@Controller
@RequestMapping("/ex_works")
public class Ex_worksController {
	@Autowired
	private Ex_worksService ex_worksService;

	@GetMapping
	  public String ex_worksIndex(Model model) {
	    List<Ex_works> ex_workss = ex_worksService.findAll();
	    model.addAttribute("ex_workss", ex_workss);
	    return "ex_worksIndex";
	}

	@GetMapping("ex_worksNew")
	public String newEx_works(Model model) {
		return "ex_worksNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Ex_works ex_works = ex_worksService.findOne(id);
		model.addAttribute("ex_works",ex_works);
		return "ex_worksEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Ex_works ex_works) {
		ex_worksService.save(ex_works);
		return "redirect:/ex_works";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Ex_works ex_works) {
        ex_works.setId(id);
        ex_worksService.save(ex_works);
        return "redirect:/ex_works";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        ex_worksService.delete(id);
        return "redirect:/ex_works";
    }
}