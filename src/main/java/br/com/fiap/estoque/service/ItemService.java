package br.com.fiap.estoque.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.estoque.domain.Item;
import br.com.fiap.estoque.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repository;

	public Page<Item> listItens() {
		return repository.findAll(PageRequest.of(0, 3));
	}

	public Item listItemPorId(Integer id) {
		Optional<Item> opItem = repository.findById(id);
		return opItem.get();
	}

	public void adicionarItem(Item item) {
		repository.save(item);
	}

	public void removerItem(Integer id) {
		repository.deleteById(id);
	}
}
