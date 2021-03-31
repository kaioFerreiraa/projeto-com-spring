package com.kaioferreira.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaioferreira.cursoudemy.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
}
