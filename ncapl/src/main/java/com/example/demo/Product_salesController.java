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

import com.example.demo.model.Product_sales;
import com.example.demo.service.Product_salesService;

@Controller
@RequestMapping("/product_sales")
public class Product_salesController {
	@Autowired
	private Product_salesService product_salesService;

	@GetMapping
	  public String product_salesIndex(Model model) {
	    List<Product_sales> product_saless = product_salesService.findAll();
	    model.addAttribute("product_saless", product_saless);
	    return "product_salesIndex";
	}

	@GetMapping("product_salesNew")
	public String newProduct_sales(Model model) {
		return "product_salesNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Product_sales product_sales = product_salesService.findOne(id);
		model.addAttribute("product_sales",product_sales);
		return "product_salesEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Product_sales product_sales) {
		product_salesService.save(product_sales);
		return "redirect:/product_sales";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Product_sales product_sales) {
        product_sales.setId(id);
        product_salesService.save(product_sales);
        return "redirect:/product_sales";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        product_salesService.delete(id);
        return "redirect:/product_sales";
    }
}