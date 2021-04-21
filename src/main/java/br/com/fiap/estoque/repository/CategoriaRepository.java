package br.com.fiap.estoque.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.estoque.domain.Categoria;

@Repository
public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Integer> {

}
