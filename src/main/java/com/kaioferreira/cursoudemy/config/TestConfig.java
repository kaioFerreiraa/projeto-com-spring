package com.kaioferreira.cursoudemy.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.kaioferreira.cursoudemy.entities.Order;
import com.kaioferreira.cursoudemy.entities.User;
import com.kaioferreira.cursoudemy.entities.enums.OrderStatus;
import com.kaioferreira.cursoudemy.repositories.OrderRepository;
import com.kaioferreira.cursoudemy.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "23912733", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "23943433", "123456");
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user1, OrderStatus.PAID);
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), user2, OrderStatus.WAITING_PAYMENT);
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), user1, OrderStatus.WAITING_PAYMENT);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		
	}
	
	
}
