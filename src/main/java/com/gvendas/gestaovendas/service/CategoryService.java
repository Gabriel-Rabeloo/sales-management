package com.gvendas.gestaovendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category update(Long id, Category category) {
		Category categorySave = validateCategoryExists(id);
		BeanUtils.copyProperties(category, categorySave, "id");
		return categoryRepository.save(categorySave);
	}

	private Category validateCategoryExists(Long id) {
		Optional<Category> category = searchById(id);
		if(category.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return category.get();
	}
}
