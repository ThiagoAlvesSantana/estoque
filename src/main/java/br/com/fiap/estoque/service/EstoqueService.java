package br.com.fiap.estoque.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fiap.estoque.domain.Estoque;
import br.com.fiap.estoque.repository.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository repository;

	public Page<Estoque> listEstoque() {
		return repository.findAll(PageRequest.of(0, 3));
	}

	public Estoque listEstoquePorEstabelecimento(Long id) {
		Optional<Estoque> opEstoque = repository.findById(id);
		return opEstoque.get();
	}

	public void adicionarItemEstabelecimento(Estoque estoque) {
		repository.save(estoque);
	}

	public void removerItemEstabeleciomento(Long id) {
		repository.deleteById(id);
	}
}