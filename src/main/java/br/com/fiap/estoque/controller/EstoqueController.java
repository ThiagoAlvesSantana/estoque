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

import br.com.fiap.estoque.domain.Estoque;
import br.com.fiap.estoque.service.EstoqueService;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {

	@Autowired
	private EstoqueService service;

	@GetMapping()
	public ResponseEntity<Page<Estoque>> listEstoque() {
		final Page<Estoque> estoque = service.listEstoque().map(Estoque::new);
		return ResponseEntity.ok(estoque);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Estoque> listEstoquePorEstabelecimento(Long id) {
		final Estoque estoque = service.listEstoquePorEstabelecimento(id);
		return ResponseEntity.ok(estoque);
	}

	@PutMapping()
	public ResponseEntity<Estoque> adicionarItemEstabelecimento(Estoque estoque) {
		service.adicionarItemEstabelecimento(estoque);
		return ResponseEntity.created(new URI("/estoque/"+estoque.getNome())).build();
	}

	@DeleteMapping(path = "{id}")
	public ResponseEntity<Estoque> removerItemEstabeleciomento(Long id) {
		service.removerItemEstabeleciomento(id);
		return ResponseEntity.ok().build();

	}
}
