package com.devsuperior.uri2602;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.CustomerProjection.CustomerProjection;
import com.devsuperior.uri2602.CustomerRepositories.CustomerRepository;
import com.devsuperior.uri2602.dto.CustomerDTO;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<CustomerProjection> list = repository.search("RS");
		List<CustomerDTO> result = list.stream().map(x -> new CustomerDTO(x)).collect(Collectors.toList());
		
		System.out.println("Result SQL: ");
		for(CustomerDTO x: result) {
			System.out.println(x);
		}
		System.out.println("\n\n ");
		
		List<CustomerDTO> list1 = repository.search1("RS");
		
		
		System.out.println("Result JPQL: ");
		for(CustomerDTO x: list1) {
			System.out.println(x);
		}
		System.out.println("\n\n");
	}
}
