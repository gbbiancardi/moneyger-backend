package br.com.gerenciador.moneyger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciador.moneyger.model.Despesa;
import br.com.gerenciador.moneyger.repositories.DespesaRepository;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository repository;
	
	public List<Despesa> findAll() {
		return repository.findAll();
	}
	
	public Despesa findById(Long id) {
		Optional<Despesa> obj = repository.findById(id);
		return obj.get();
	}
}
