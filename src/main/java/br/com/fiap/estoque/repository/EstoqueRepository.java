package br.com.fiap.estoque.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.estoque.domain.Estoque;

@Repository
public interface EstoqueRepository extends PagingAndSortingRepository<Estoque, Long> {

}
