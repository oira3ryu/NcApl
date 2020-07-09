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

import com.example.demo.model.Flg;
import com.example.demo.service.FlgService;

@Controller
@RequestMapping("/flg")
public class FlgController {
	@Autowired
	private FlgService flgService;

	@GetMapping
	  public String flgIndex(Model model) {
	    List<Flg> flgs = flgService.findAll();
	    model.addAttribute("flgs", flgs);
	    return "flgIndex";
	}

	@GetMapping("flgNew")
	public String newFlg(Model model) {
		return "flgNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Flg flg = flgService.findOne(id);
		model.addAttribute("flg",flg);
		return "flgEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Flg flg) {
		flgService.save(flg);
		return "redirect:/flg";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Flg flg) {
        flg.setId(id);
        flgService.save(flg);
        return "redirect:/flg";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        flgService.delete(id);
        return "redirect:/flg";
    }
}