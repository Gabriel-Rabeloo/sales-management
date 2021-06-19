package com.gvendas.gestaovendas.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gvendas.gestaovendas.entities.Category;
import com.gvendas.gestaovendas.repository.CategoryRepository;
import com.gvendas.gestaovendas.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public List<Category> listAll(){
		return categoryService.listAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Category>> searchById(@PathVariable Long id) {
		Optional<Category> category = categoryService.searchById(id);
		return category.isPresent() ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Category> save(@Valid @RequestBody Category category){
		Category categorySaved = categoryService.save(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(categorySaved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> update(@PathVariable Long id,@Valid @RequestBody Category category) {
		return ResponseEntity.ok(categoryService.update(id, category));
	}
}
