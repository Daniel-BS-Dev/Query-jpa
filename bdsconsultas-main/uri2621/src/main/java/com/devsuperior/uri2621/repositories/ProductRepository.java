package com.devsuperior.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.uri2621.dto.ProductDTO;
import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductProjection;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	// consulta que retorna o nome do produto que esteja entre o min e o max que a inicial letra name
	
	@Query(nativeQuery=true, value="SELECT prod.name FROM products prod "
			+ "JOIN providers prov ON prov.id = prod.id_providers "
			+ "WHERE prod.amount BETWEEN :min AND :max AND prov.name LIKE CONCAT(:name, '%')")
	List<ProductProjection> search(Integer min, Integer max, String name);
	
	
	@Query("SELECT new com.devsuperior.uri2621.dto.ProductDTO(prod.name) "
			+ "FROM Product prod "
			+ "WHERE prod.amount BETWEEN :min AND :max AND prod.provider.name LIKE CONCAT(:name, '%')")
	List<ProductDTO> search1(Integer min, Integer max, String name);


}
