package com.kaioferreira.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaioferreira.cursoudemy.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}
