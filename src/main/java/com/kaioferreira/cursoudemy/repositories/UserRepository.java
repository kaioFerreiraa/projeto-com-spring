package com.kaioferreira.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaioferreira.cursoudemy.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
