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
	
	public Despesa insert(Despesa obj) throws Exception {
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

	public Despesa update(Long id, Despesa obj) {
		try {
			Despesa entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Despesa entity, Despesa obj) {
		entity.setDescricao(obj.getDescricao());
		entity.setTipoDespesa(obj.getTipoDespesa());
		entity.setValor(obj.getValor());
		entity.setData(obj.getData());
	}
}
