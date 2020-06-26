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

import com.example.demo.model.Plant;
import com.example.demo.service.PlantService;

@Controller
@RequestMapping("/plant")
public class PlantController {
	@Autowired
	private PlantService plantService;

	@GetMapping
	  public String plantIndex(Model model) {
	    List<Plant> plants = plantService.findAll();
	    model.addAttribute("plants", plants);
	    return "plantIndex";
	}

	@GetMapping("plantNew")
	public String newPlant(Model model) {
		return "plantNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Plant plant = plantService.findOne(id);
		model.addAttribute("plant",plant);
		return "plantEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Plant plant) {
		plantService.save(plant);
		return "redirect:/plant";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Plant plant) {
        plant.setId(id);
        plantService.save(plant);
        return "redirect:/plant";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        plantService.delete(id);
        return "redirect:/plant";
    }
}