package br.com.gerenciador.moneyger.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.gerenciador.moneyger.exceptions.DatabaseException;
import br.com.gerenciador.moneyger.exceptions.ResourceNotFoundException;
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
	
	public Receita insert(Receita obj) throws Exception {
		return repository.save(obj);	
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Receita update(Long id, Receita obj) {
		try {
			Receita entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Receita entity, Receita obj) {
		entity.setDescricao(obj.getDescricao());
		entity.setTipoReceita(obj.getTipoReceita());
		entity.setValor(obj.getValor());
		entity.setData(obj.getData());
	}
}
