package com.devsuperior.uri2621;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.dto.ProductDTO;
import com.devsuperior.uri2621.projections.ProductProjection;
import com.devsuperior.uri2621.repositories.ProductRepository;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<ProductProjection> list = repository.search(10,20,"P");
		List<ProductDTO> result = list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
		
		System.out.println("RESULT SQL:");
		for(ProductDTO x: result) {
			System.out.println(x);
		}
		System.out.println("\n");
		
		
		
		List<ProductDTO> list1 = repository.search1(10,20,"P");
		System.out.println("RESULT JPQL:");
		for(ProductDTO x: list1) {
			System.out.println(x);
		}
		System.out.println("\n");
		
		
	}
}
