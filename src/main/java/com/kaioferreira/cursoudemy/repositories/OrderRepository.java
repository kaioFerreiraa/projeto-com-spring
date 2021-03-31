package com.kaioferreira.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaioferreira.cursoudemy.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
