package com.devsuperior.uri2737.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2737.entities.Lawyer;
import com.devsuperior.uri2737.projections.LawyerMinProjection;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
	
	// consulta retornando menor, maior e a media de todos, como eu estou usando union e jpql não tem 
	
	@Query(nativeQuery=true, value="(SELECT name, customers_number AS customersNumber FROM lawyers "// como meu customers_number e separado pelo _ entao eu precisei dar esse apelido a ele" AS customersNumber"
			+ "WHERE customers_number = (SELECT MAX(customers_number) FROM lawyers )) "
			+ "UNION ALL " // union sem o all não traz valores repitidos
			+ "(SELECT name, customers_number FROM lawyers "
			+ "WHERE customers_number = (SELECT MIN(customers_number) FROM lawyers )) "
			+ "UNION ALL "
			+ "(SELECT 'Average', ROUND(AVG(customers_number),0) FROM lawyers)")// round arredona o valor 0 e o total de casas dps da virgula
	List<LawyerMinProjection> search();

}
