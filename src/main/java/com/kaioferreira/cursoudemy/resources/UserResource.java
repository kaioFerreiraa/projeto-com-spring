package com.kaioferreira.cursoudemy.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaioferreira.cursoudemy.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll() {
		User user = new User(1L, "Maria", "maria@gmail.com", "27398237", "12345");
		return ResponseEntity.ok().body(user);
	}
}
