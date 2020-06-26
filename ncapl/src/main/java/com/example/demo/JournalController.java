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

import com.example.demo.model.Journal;
import com.example.demo.service.JournalService;

@Controller
@RequestMapping("/journal")
public class JournalController {
	@Autowired
	private JournalService journalService;

	@GetMapping
	  public String journalIndex(Model model) {
	    List<Journal> journals = journalService.findAll();
	    model.addAttribute("journals", journals);
	    return "journalIndex";
	}

	@GetMapping("journalNew")
	public String newJournal(Model model) {
		return "journalNew";
	}

	@GetMapping("{id}/edit")
	public String edit(@PathVariable Integer id,Model model) {
		Journal journal = journalService.findOne(id);
		model.addAttribute("journal",journal);
		return "journalEdit";
	}

	@PostMapping
	public String create(@ModelAttribute Journal journal) {
		journalService.save(journal);
		return "redirect:/journal";
	}

	@PostMapping("{id}/edit")
    public String update(@PathVariable Integer id, @ModelAttribute Journal journal) {
        journal.setId(id);
        journalService.save(journal);
        return "redirect:/journal";
    }

    @PostMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        journalService.delete(id);
        return "redirect:/journal";
    }
}