package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Discount_amount;
import com.example.demo.repository.Discount_amountRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class Discount_amountService {

	@Autowired
	Discount_amountRepository repository;

	public List<Discount_amount> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

    public List<Discount_amount> findByForm(Discount_amount searchParam) {

        if (searchParam == null) {
            return findAll();
        }

        return repository.findAll(Example.of(searchParam));
    }

	public Discount_amount findOne(Integer id) {
		Optional<Discount_amount> discount_amount = repository.findById(id);
		if (discount_amount.isPresent()) {
			return discount_amount.get();
		} else {
			return null;
		}
	}

	public Discount_amount save(Discount_amount discount_amount) {
		return repository.save(discount_amount);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
