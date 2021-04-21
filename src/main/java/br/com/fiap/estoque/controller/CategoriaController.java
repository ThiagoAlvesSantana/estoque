package br.com.fiap.estoque.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.estoque.domain.Categoria;
import br.com.fiap.estoque.service.CategoriaService;

@RestController
@RequestMapping(path = "categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping()
	public ResponseEntity<Page<Categoria>> listCategorias() {
		final Page<Categoria> categoria = service.listCategorias().map(Categoria::new);
		return ResponseEntity.ok(categoria);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Categoria> listCategoriaPorId(@PathVariable Integer id) {
		final Categoria categoria = service.listCategoriaPorId(id);
		return ResponseEntity.ok(categoria);
	}

	@PutMapping()
	public ResponseEntity<Categoria> adicionarCategoria(@RequestBody Categoria categoria) throws URISyntaxException {
		service.adicionarCategoria(categoria);
		return ResponseEntity.created(new URI("/item/" + categoria.getNome())).build();
	}

	@DeleteMapping(path = "{id}")
	public ResponseEntity<Categoria> removerCategoria(@PathVariable Integer id) {
		service.removerCategoria(id);
		return ResponseEntity.ok().build();
	}
}
