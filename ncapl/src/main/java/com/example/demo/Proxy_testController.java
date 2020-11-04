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

import com.example.demo.model.Proxy_test;
import com.example.demo.service.Proxy_testService;

@Controller
@RequestMapping("/proxy_test")
public class Proxy_testController {
	@Autowired
	private Proxy_testService proxy_testService;

	@GetMapping
	  public String proxy_testIndex(Model model) {
	    List<Proxy_test> proxy_tests = proxy_testService.findAll();
	    model.addAttribute("proxy_tests", proxy_tests);
	    return "proxy_testIndex";
	}

	@GetMapping("proxy_testNew")
	public String newProxy_test(Model model) {
		return "proxy_testNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Proxy_test proxy_test = proxy_testService.findOne(id);
		model.addAttribute("proxy_test",proxy_test);
		return "proxy_testEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Proxy_test proxy_test) {
		proxy_testService.save(proxy_test);
		return "redirect:/proxy_test";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Proxy_test proxy_test) {
        proxy_test.setId(id);
        proxy_testService.save(proxy_test);
        return "redirect:/proxy_test";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        proxy_testService.delete(id);
        return "redirect:/proxy_test";
    }
}