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

import com.example.demo.model.Company;
import com.example.demo.model.Discount_amount;
import com.example.demo.model.Flg;
import com.example.demo.model.Product_name;
import com.example.demo.model.Product_name_view;
import com.example.demo.service.CompanyService;
import com.example.demo.service.Discount_amountService;
import com.example.demo.service.FlgService;
import com.example.demo.service.Product_nameService;
import com.example.demo.service.Product_name_viewService;

@Controller
@RequestMapping("/discount_amount")
public class Discount_amountController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private Discount_amountService discount_amountService;

	@Autowired
	private Product_nameService product_nameService;

	@Autowired
	private Product_name_viewService product_name_viewService;

	@Autowired
	private FlgService flgService;

	@GetMapping
	  public String discount_amountIndex(Model model) {

		List<Discount_amount> discount_amounts = discount_amountService.findAll();
	    model.addAttribute("discount_amountlist",discount_amounts);

	    List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

	    List<Company> companys = companyService.findAll();
		model.addAttribute("companylist", companys);

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

		model.addAttribute("searchParam", new Discount_amount());

		return "discount_amountIndex";

	}

	@GetMapping("discount_amountNew")
	public String newdiscount_amounte(Model model) {

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

	    List<Company> companys = companyService.findAll();
		model.addAttribute("companylist", companys);

		List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		return "discount_amountNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {

		Discount_amount discount_amounts = discount_amountService.findOne(id);
		model.addAttribute("discount_amountlist",discount_amounts);

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

	    List<Company> companys = companyService.findAll();
		model.addAttribute("companylist", companys);

		List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		return "discount_amountEdit";
	}

    @PostMapping("search")
    public String search(@ModelAttribute("searchParam") Discount_amount form, Model model) {

    	List<Discount_amount> discount_amounts =
                discount_amountService.findByForm(form);
        model.addAttribute("discount_amountlist",discount_amounts);
        model.addAttribute("searchParam", form);

        List<Product_name> product_names = product_nameService.findAll();
		model.addAttribute("product_namelist", product_names);

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

	    List<Company> companys = companyService.findAll();
		model.addAttribute("companylist", companys);

		List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		return "discount_amountIndex";
    }

	@PostMapping
	public String create(@ModelAttribute Discount_amount discount_amount) {
		discount_amountService.save(discount_amount);
		return "redirect:/discount_amount";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Discount_amount discount_amount) {
        discount_amount.setId(id);
        discount_amountService.save(discount_amount);
        return "redirect:/discount_amount";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        discount_amountService.delete(id);
        return "redirect:/discount_amount";
    }
}