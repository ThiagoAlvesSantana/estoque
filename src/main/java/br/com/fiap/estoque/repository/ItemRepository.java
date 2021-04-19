package br.com.fiap.estoque.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.estoque.domain.Item;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Integer>{

}
