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

import com.example.demo.model.Slump;
import com.example.demo.service.SlumpService;

@Controller
@RequestMapping("/slump")
public class SlumpController {
	@Autowired
	private SlumpService slumpService;

	@GetMapping
	  public String slumpIndex(Model model) {
	    List<Slump> slumps = slumpService.findAll();
	    model.addAttribute("slumps", slumps);
	    return "slumpIndex";
	}

	@GetMapping("slumpNew")
	public String newSlump(Model model) {
		return "slumpNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Slump slump = slumpService.findOne(id);
		model.addAttribute("slump",slump);
		return "slumpEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Slump slump) {
		slumpService.save(slump);
		return "redirect:/slump";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Slump slump) {
        slump.setId(id);
        slumpService.save(slump);
        return "redirect:/slump";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        slumpService.delete(id);
        return "redirect:/slump";
    }
}