package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User (null, "Maria Bronw", "maria@gmail.com", "999888979", "12344");
		User u2 = new User (null, "Alex Pink", "alex@gmail.com", "999887979", "12345");
		
		Order o1 = new Order (null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order (null, Instant.parse("2019-07-21T09:13:03Z"), u2);
		Order o3 = new Order (null, Instant.parse("2019-08-26T20:30:12Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		

	}
}
