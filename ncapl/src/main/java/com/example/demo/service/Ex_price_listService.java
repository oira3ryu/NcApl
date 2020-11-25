package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Ex_price_list;
import com.example.demo.repository.Ex_price_listRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class Ex_price_listService {

	@Autowired
	Ex_price_listRepository repository;

	public List<Ex_price_list> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "explid"));
	}

    public List<Ex_price_list> findByForm(Ex_price_list searchParam) {

        if (searchParam == null) {
            return findAll();
        }

        return repository.findAll(Example.of(searchParam));
    }

	public Ex_price_list findOne(Integer id) {
		Optional<Ex_price_list> ex_price_list = repository.findById(id);
		if (ex_price_list.isPresent()) {
			return ex_price_list.get();
		} else {
			return null;
		}
	}

	public Ex_price_list save(Ex_price_list ex_price_list) {
		return repository.save(ex_price_list);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}
}