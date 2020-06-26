package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Journal;
@Repository
	public interface JournalRepository extends JpaRepository<Journal, Integer> {}