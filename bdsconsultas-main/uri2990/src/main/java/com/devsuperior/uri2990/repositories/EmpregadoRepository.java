package com.devsuperior.uri2990.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.entities.Empregado;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
	
	// consulta retornando apenas funcionarios que não estão trabalhando em nenhum projeto
	
	@Query(nativeQuery=true, value="SELECT emp.cpf, emp.enome, dep.dnome "
			+ "			FROM empregados emp "
			+ "		    INNER JOIN departamentos dep ON emp.dnumero = dep.dnumero "
			+ "			WHERE emp.cpf NOT IN ("
			+ "			SELECT emp.cpf "
			+ "			FROM empregados emp "
			+ "			INNER JOIN trabalha trab ON trab.cpf_emp = emp.cpf)")
	List<EmpregadoDeptProjection> search();

	
	@Query("SELECT new com.devsuperior.uri2990.dto.EmpregadoDeptDTO(obj.cpf, obj.enome, obj.departamento.dnome) "
			+ "			FROM Empregado obj "
			+ "			WHERE obj.cpf NOT IN ("
			+ "			SELECT emp.cpf "
			+ "			FROM Empregado emp "
			+ "			INNER JOIN emp.projetosOndeTrabalha)")
	List<EmpregadoDeptDTO> search1();

}
