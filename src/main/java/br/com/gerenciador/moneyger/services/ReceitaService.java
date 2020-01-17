package br.com.gerenciador.moneyger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciador.moneyger.model.Receita;
import br.com.gerenciador.moneyger.repositories.ReceitaRepository;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository repository;
	
	public List<Receita> findAll() {
		return repository.findAll();
	}
	
	public Receita findById(Long id) {
		Optional<Receita> obj = repository.findById(id);
		return obj.get();
	}
}
