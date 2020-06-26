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

import com.example.demo.model.Aggregate;
import com.example.demo.service.AggregateService;

@Controller
@RequestMapping("/aggregate")
public class AggregateCotroller {
	@Autowired
	private AggregateService aggregateService;

	@GetMapping
	  public String aggregateIndex(Model model) {
	    List<Aggregate> aggregates = aggregateService.findAll();
	    model.addAttribute("aggregates", aggregates);
	    return "aggregateIndex";
	}

	@GetMapping("aggregateNew")
	public String newAggregate(Model model) {
		return "aggregateNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Aggregate aggregate = aggregateService.findOne(id);
		model.addAttribute("aggregate",aggregate);
		return "aggregateEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Aggregate aggregate) {
		aggregateService.save(aggregate);
		return "redirect:/aggregate";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Aggregate aggregate) {
        aggregate.setId(id);
        aggregateService.save(aggregate);
        return "redirect:/aggregate";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        aggregateService.delete(id);
        return "redirect:/aggregate";
    }
}