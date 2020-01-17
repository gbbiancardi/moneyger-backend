package br.com.gerenciador.moneyger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciador.moneyger.model.Objetivo;
import br.com.gerenciador.moneyger.repositories.ObjetivoRepository;

@Service
public class ObjetivoService {

	@Autowired
	private ObjetivoRepository repository;
	
	public List<Objetivo> findAll() {
		return repository.findAll();
	}
	
	public Objetivo findById(Long id) {
		Optional<Objetivo> obj = repository.findById(id);
		return obj.get();
	}
}
