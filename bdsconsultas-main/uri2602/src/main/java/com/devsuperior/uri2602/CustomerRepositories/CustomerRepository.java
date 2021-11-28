package com.devsuperior.uri2602.CustomerRepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.uri2602.CustomerProjection.CustomerProjection;
import com.devsuperior.uri2602.dto.CustomerDTO;
import com.devsuperior.uri2602.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	// consulta em SQL buscar name de pessoas que moram no 'RS'

	@Query(nativeQuery=true, value="SELECT name FROM customers "
			+ "WHERE UPPER(state) = UPPER('RS')")
	List<CustomerProjection> search(String name);
	
	//a mesma pesquisa em jpql
	@Query("SELECT new com.devsuperior.uri2602.dto.CustomerDTO(obj.name) "
			+ "FROM Customer obj "
			+ "WHERE UPPER(state) = UPPER('RS')")
	List<CustomerDTO> search1(String name);
}
