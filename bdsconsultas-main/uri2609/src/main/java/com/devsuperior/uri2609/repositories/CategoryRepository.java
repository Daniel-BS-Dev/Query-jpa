package com.devsuperior.uri2609.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.entities.Category;
import com.devsuperior.uri2609.projections.CategorySumProjection;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	//CONSULTA QUE VOLTAR O NOME DA CATEGORIA E A SOMA DE PRODUTOS EM CADA CATEGORIA
	
	@Query(nativeQuery=true, value="SELECT ca.name, sum(pr.amount) FROM categories ca "
			+ "join products pr on ca.id = pr.id_categories "
			+ "group by ca.name")
	List<CategorySumProjection> search();
	
	@Query("SELECT new com.devsuperior.uri2609.dto.CategorySumDTO(p.category.name, sum(p.amount)) "
			+ "FROM Product p "    // como no meu product eu eu recebo uma category então eu tenho acessa atraves dela
			+ "group by p.category.name")
	List<CategorySumDTO> search1();

}
