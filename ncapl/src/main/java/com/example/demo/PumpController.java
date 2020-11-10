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

import com.example.demo.model.Pump;
import com.example.demo.service.PumpService;

@Controller
@RequestMapping("/pump")
public class PumpController {
	@Autowired
	private PumpService pumpService;

	@GetMapping
	  public String pumpIndex(Model model) {
	    List<Pump> pumps = pumpService.findAll();
	    model.addAttribute("pumps", pumps);
	    return "pumpIndex";
	}

	@GetMapping("pumpNew")
	public String newPump(Model model) {
		return "pumpNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Pump pump = pumpService.findOne(id);
		model.addAttribute("pump",pump);
		return "pumpEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Pump pump) {
		pumpService.save(pump);
		return "redirect:/pump";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Pump pump) {
        pump.setId(id);
        pumpService.save(pump);
        return "redirect:/pump";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        pumpService.delete(id);
        return "redirect:/pump";
    }
}