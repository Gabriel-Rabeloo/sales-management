package com.gvendas.gestaovendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gvendas.gestaovendas.entities.Category;
import com.gvendas.gestaovendas.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> listAll() {
		return categoryRepository.findAll();
	}
	
	public Optional<Category> searchById(Long id) {
		return categoryRepository.findById(id);
	}
}
