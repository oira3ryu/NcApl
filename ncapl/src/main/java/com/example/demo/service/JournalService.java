package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Journal;
import com.example.demo.repository.JournalRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class JournalService {

	@Autowired
	JournalRepository journalrepository;

	public List<Journal> findAll() {
		return journalrepository.findAll();
	}

	public Journal findOne(Integer id) {
		Optional<Journal> journal = journalrepository.findById(id);
		if (journal.isPresent()) {
			return journal.get();
		} else {
			return null;
		}
	}

	public Journal save(Journal journal) {
		return journalrepository.save(journal);
	}

	public void delete(Integer id) {
		journalrepository.deleteById(id);
	}
}
