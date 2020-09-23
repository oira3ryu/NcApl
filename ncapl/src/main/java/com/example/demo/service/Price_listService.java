package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Price_list;
import com.example.demo.repository.Price_listRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class Price_listService {

	@Autowired
	Price_listRepository repository;

	public List<Price_list> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "plid"));
	}

    public List<Price_list> findByForm(Price_list searchParam) {

        if (searchParam == null) {
            return findAll();
        }

        return repository.findAll(Example.of(searchParam));
    }

	public Price_list findOne(Integer id) {
		Optional<Price_list> price_list = repository.findById(id);
		if (price_list.isPresent()) {
			return price_list.get();
		} else {
			return null;
		}
	}

	public Price_list save(Price_list price_list) {
		return repository.save(price_list);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}