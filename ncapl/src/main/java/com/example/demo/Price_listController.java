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
import com.example.demo.model.Journal;
import com.example.demo.model.Price_list;
import com.example.demo.model.Product_name;
import com.example.demo.model.Product_name_view;
import com.example.demo.service.FlgService;
import com.example.demo.service.JournalService;
import com.example.demo.service.Price_listService;
import com.example.demo.service.Product_nameService;
import com.example.demo.service.Product_name_viewService;

@Controller
@RequestMapping("/price_list")
public class Price_listController {

	@Autowired
	private Price_listService price_listService;

	@Autowired
	private Product_nameService product_nameService;

	@Autowired
	private Product_name_viewService product_name_viewService;

	@Autowired
	private FlgService flgService;

	@Autowired
	private JournalService journalService;

	@GetMapping
	  public String price_listIndex(Model model) {

		List<Price_list> price_lists = price_listService.findAll();
	    model.addAttribute("price_listlist",price_lists);

	    List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

		model.addAttribute("searchParam", new Price_list());

		return "price_listIndex";

	}

	@GetMapping("price_listNew")
	public String newprice_liste(Model model) {

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

		List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		return "price_listNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {

		Price_list price_lists = price_listService.findOne(id);
		model.addAttribute("price_listlist",price_lists);

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

		List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		return "price_listEdit";
	}

    @PostMapping("search")
    public String search(@ModelAttribute("searchParam") Price_list form, Model model) {

    	List<Price_list> price_lists =
                price_listService.findByForm(form);
        model.addAttribute("price_listlist",price_lists);
        model.addAttribute("searchParam", form);

        List<Product_name> product_names = product_nameService.findAll();
		model.addAttribute("product_namelist", product_names);

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

		List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		List<Journal> journals = journalService.findAll();
		model.addAttribute("journallist", journals);

		return "price_listIndex";
    }

	@PostMapping
	public String create(@ModelAttribute Price_list price_list) {
		price_listService.save(price_list);
		return "redirect:/price_list";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Price_list price_list) {
        price_list.setPlid(id);
        price_listService.save(price_list);
        return "redirect:/price_list";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        price_listService.delete(id);
        return "redirect:/price_list";
    }
}