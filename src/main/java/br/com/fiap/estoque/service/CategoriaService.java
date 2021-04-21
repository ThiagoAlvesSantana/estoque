package br.com.fiap.estoque.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.estoque.domain.Categoria;
import br.com.fiap.estoque.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Page<Categoria> listCategorias() {
		return repository.findAll(PageRequest.of(0, 3));
	}

	public Categoria listCategoriaPorId(Integer id) {
		Optional<Categoria> opCategoria = repository.findById(id);
		return opCategoria.get();
	}

	public void adicionarCategoria(Categoria categoria) {
		repository.save(categoria);
	}

	public void removerCategoria(Integer id) {
		repository.deleteById(id);
	}
}