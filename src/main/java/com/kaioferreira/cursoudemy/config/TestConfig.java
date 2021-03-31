package com.kaioferreira.cursoudemy.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.kaioferreira.cursoudemy.entities.Category;
import com.kaioferreira.cursoudemy.entities.Order;
import com.kaioferreira.cursoudemy.entities.OrderItem;
import com.kaioferreira.cursoudemy.entities.Product;
import com.kaioferreira.cursoudemy.entities.User;
import com.kaioferreira.cursoudemy.entities.enums.OrderStatus;
import com.kaioferreira.cursoudemy.repositories.CategoryRepository;
import com.kaioferreira.cursoudemy.repositories.OrderItemRepository;
import com.kaioferreira.cursoudemy.repositories.OrderRepository;
import com.kaioferreira.cursoudemy.repositories.ProductRepository;
import com.kaioferreira.cursoudemy.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired 
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category category1 = new Category(null, "Eletronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		
		p1.getCategories().add(category2);	
		p2.getCategories().add(category1);
		p2.getCategories().add(category3);
		p3.getCategories().add(category3);
		p4.getCategories().add(category3);
		p5.getCategories().add(category2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "23912733", "123456");
		User user2 = new User(null, "Alex Green", "alex@gmail.com", "23943433", "123456");
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user1, OrderStatus.PAID);
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), user2, OrderStatus.WAITING_PAYMENT);
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), user1, OrderStatus.WAITING_PAYMENT);		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		
		OrderItem oi1 = new OrderItem(order1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(order1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(order2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(order3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
	}
	
	
}
