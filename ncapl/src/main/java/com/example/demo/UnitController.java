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

import com.example.demo.model.Unit;
import com.example.demo.service.UnitService;

@Controller
@RequestMapping("/unit")
public class UnitController {
	@Autowired
	private UnitService unitService;

	@GetMapping
	  public String unitIndex(Model model) {
	    List<Unit> units = unitService.findAll();
	    model.addAttribute("units", units);
	    return "unitIndex";
	}

	@GetMapping("unitNew")
	public String newUnit(Model model) {
		return "unitNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Unit unit = unitService.findOne(id);
		model.addAttribute("unit",unit);
		return "unitEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Unit unit) {
		unitService.save(unit);
		return "redirect:/unit";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Unit unit) {
        unit.setId(id);
        unitService.save(unit);
        return "redirect:/unit";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        unitService.delete(id);
        return "redirect:/unit";
    }
}