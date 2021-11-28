package com.devsuperior.uri2611;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dto.MoviesDTO;
import com.devsuperior.uri2611.projections.MoviesProjection;
import com.devsuperior.uri2611.repositories.MoviesRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {
	
	@Autowired
	private MoviesRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<MoviesProjection> list = repository.search("Action");
		List<MoviesDTO> result = list.stream().map(x -> new MoviesDTO(x)).collect(Collectors.toList());
		
		System.out.println("Result SQL: ");
		for(MoviesDTO x: result) {
			System.out.println(x);
		}
		System.out.println("\n\n ");
		
		
		List<MoviesDTO> list1 = repository.search1("Action");
		
		System.out.println("Result JPQL: ");
		for(MoviesDTO x: list1) {
			System.out.println(x);
		}
		System.out.println("\n\n");
		
	}
}
