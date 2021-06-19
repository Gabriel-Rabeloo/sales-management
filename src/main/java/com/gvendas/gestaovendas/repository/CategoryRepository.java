package com.gvendas.gestaovendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gvendas.gestaovendas.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
