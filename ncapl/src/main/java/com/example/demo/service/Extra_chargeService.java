package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Extra_charge;
import com.example.demo.repository.Extra_chargeRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class Extra_chargeService {

	@Autowired
	Extra_chargeRepository repository;

	public List<Extra_charge> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Extra_charge findOne(Integer id) {
		Optional<Extra_charge> extra_charge = repository.findById(id);
		if (extra_charge.isPresent()) {
			return extra_charge.get();
		} else {
			return null;
		}
	}

	public Extra_charge save(Extra_charge extra_charge) {
		return repository.save(extra_charge);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
