package com.devsuperior.uri2611.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.uri2611.dto.MoviesDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MoviesProjection;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Long> {
	
// consulta retornando o nome e id dos filmes relacionados a genero recebido pelo usuario

	@Query(nativeQuery=true, value="SELECT m.id, m.name FROM movies m "
			+ "INNER JOIN genres g "
			+ "ON g.id = m.id_genres "
			+ "WHERE UPPER(g.description) = UPPER(:genres)")
	List<MoviesProjection> search(String genres);
	
	@Query("SELECT new com.devsuperior.uri2611.dto.MoviesDTO(m.id, m.name) " 
			+ "FROM Movie m "
			+ "WHERE LOWER(m.genre.description) = LOWER(:genreName)")// como eu tenho um relacionamento um para muito da minha class movie com genres
	List<MoviesDTO> search1(String genreName);                       // então eu posso acessa atraves do nome do emu atributo que faz o relacionamnto o campo que eu quero da classe genres

}
