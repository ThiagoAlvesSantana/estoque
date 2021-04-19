package br.com.fiap.estoque.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.estoque.domain.Item;
import br.com.fiap.estoque.service.ItemService;

@RestController
@RequestMapping("/itens")
public class ItemController {

	@Autowired
	private ItemService service;

	@GetMapping()
	public ResponseEntity<Page<Item>> listItens() {
		final Page<Item> item = service.listItens().map(Item::new);
		return ResponseEntity.ok(item);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Item> listItemPorId(Integer id) {
		final Item item = service.listItemPorId(id);
		return ResponseEntity.ok(item);
	}

	@PutMapping()
	public ResponseEntity<Item> adicionarItem(Item item) {
		service.adicionarItem(item);
		return ResponseEntity.created(new URI("/item/" + item.getNome())).build();
	}

	@DeleteMapping(path = "{id}")
	public ResponseEntity<Item> removerItem(Integer id) {
		service.removerItem(id);
		return ResponseEntity.ok().build();
	}
}