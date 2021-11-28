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
			+ "WHERE UPPER(state) = UPPER(:state)")  // :state é para referencia minha string que vem na lista
	List<CustomerProjection> search(String state);
	
	//a mesma pesquisa em jpql                                                
	@Query("SELECT new com.devsuperior.uri2602.dto.CustomerDTO(obj.name) "// name atributo que vm da minha classe eu tenho que ter um construtor no dto que recebe esse nome
			+ "FROM Customer obj "                                        // Customer nome da minha classe
			+ "WHERE UPPER(state) = UPPER(:state)")                       // obj apelido da minha classe
	List<CustomerDTO> search1(String state);                              // new com.devsuperior.uri2602.dto.CustomerDTO é o import do dto 
}
