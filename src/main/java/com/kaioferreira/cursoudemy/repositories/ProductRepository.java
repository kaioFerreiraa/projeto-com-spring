package com.kaioferreira.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaioferreira.cursoudemy.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
