package com.devsuperior.uri2609;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<CategorySumProjection> list = repository.search();
		List<CategorySumDTO> result = list.stream().map(x -> new CategorySumDTO(x)).collect(Collectors.toList());
		
		System.out.println("Result SQL: ");
		for(CategorySumDTO x: result) {
			System.out.println(x);
		}
		System.out.println("\n\n ");
		
		List<CategorySumDTO> list1 = repository.search1();
		
		System.out.println("Result JPQL: ");
		for(CategorySumDTO x: list1) {
			System.out.println(x);
		}
		System.out.println("\n\n ");

	}
}
