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

import com.example.demo.model.Ex_price_list;
import com.example.demo.model.Ex_works;
import com.example.demo.model.Flg;
import com.example.demo.model.Journal;
import com.example.demo.model.Product_name;
import com.example.demo.model.Product_name_view;
import com.example.demo.service.Ex_price_listService;
import com.example.demo.service.Ex_worksService;
import com.example.demo.service.FlgService;
import com.example.demo.service.JournalService;
import com.example.demo.service.Product_nameService;
import com.example.demo.service.Product_name_viewService;

@Controller
@RequestMapping("/ex_price_list")
public class Ex_price_listController {

	@Autowired
	private Ex_worksService ex_worksService;

	@Autowired
	private Ex_price_listService ex_price_listService;

	@Autowired
	private Product_nameService product_nameService;

	@Autowired
	private Product_name_viewService product_name_viewService;

	@Autowired
	private FlgService flgService;

	@Autowired
	private JournalService journalService;

	@GetMapping
	  public String ex_price_listIndex(Model model) {

		List<Ex_works> ex_workss = ex_worksService.findAll();
	    model.addAttribute("ex_workslist",ex_workss);

		List<Ex_price_list> ex_price_lists = ex_price_listService.findAll();
	    model.addAttribute("ex_price_listlist",ex_price_lists);

	    List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

		model.addAttribute("searchParam", new Ex_price_list());

		return "ex_price_listIndex";

	}

	@GetMapping("ex_price_listNew")
	public String newex_price_liste(Model model) {

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

		List<Ex_works> ex_workss = ex_worksService.findAll();
	    model.addAttribute("ex_workslist",ex_workss);

		List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		return "ex_price_listNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {

		Ex_price_list ex_price_lists = ex_price_listService.findOne(id);
		model.addAttribute("ex_price_listlist",ex_price_lists);

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

		List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		List<Ex_works> ex_workss = ex_worksService.findAll();
	    model.addAttribute("ex_workslist",ex_workss);

		return "ex_price_listEdit";
	}

    @PostMapping("search")
    public String search(@ModelAttribute("searchParam") Ex_price_list form, Model model) {

    	List<Ex_price_list> ex_price_lists =
                ex_price_listService.findByForm(form);
        model.addAttribute("ex_price_listlist",ex_price_lists);
        model.addAttribute("searchParam", form);

        List<Product_name> product_names = product_nameService.findAll();
		model.addAttribute("product_namelist", product_names);

		List<Product_name_view> product_name_views = product_name_viewService.findAll();
		model.addAttribute("product_name_viewlist", product_name_views);

		List<Flg> flags = flgService.findAll();
		model.addAttribute("flglist", flags);

		List<Journal> journals = journalService.findAll();
		model.addAttribute("journallist", journals);

		List<Ex_works> ex_workss = ex_worksService.findAll();
	    model.addAttribute("ex_workslist",ex_workss);


		return "ex_price_listIndex";
    }

	@PostMapping
	public String create(@ModelAttribute Ex_price_list ex_price_list) {
		ex_price_listService.save(ex_price_list);
		return "redirect:/ex_price_list";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Ex_price_list ex_price_list) {
        ex_price_list.setExplid(id);
        ex_price_listService.save(ex_price_list);
        return "redirect:/ex_price_list";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        ex_price_listService.delete(id);
        return "redirect:/ex_price_list";
    }
}