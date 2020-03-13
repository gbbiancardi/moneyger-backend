package br.com.gerenciador.moneyger.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.gerenciador.moneyger.exceptions.DatabaseException;
import br.com.gerenciador.moneyger.exceptions.ResourceNotFoundException;
import br.com.gerenciador.moneyger.model.Objetivo;
import br.com.gerenciador.moneyger.model.enums.StatusObjetivo;
import br.com.gerenciador.moneyger.repositories.ObjetivoRepository;

@Service
public class ObjetivoService {

	@Autowired
	private ObjetivoRepository repository;
	
//	@Autowired
//	private UserService userService;
	
	public List<Objetivo> findAll() {
		return repository.findAll();
	}
	
	public Objetivo findById(Long id) {
		Optional<Objetivo> obj = repository.findById(id);
		return obj.get();
	}
	
	public Objetivo insert(Objetivo obj) throws Exception {
		obj.setId(null);
		
		Date instant = new Date();
		obj.setDataAtual(instant);
		
		obj.setStatusObjetivo(StatusObjetivo.CAMINHANDO);
		
//		obj.setClient(userService.findByEmail(obj.getClient().getEmail()));
		
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

	public Objetivo update(Long id, Objetivo obj) {
		try {
			Objetivo entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Objetivo entity, Objetivo obj) {
		entity.setDescricao(obj.getDescricao());
		entity.setMeta(obj.getMeta());
		entity.setTipoObjetivo(obj.getTipoObjetivo());
		entity.setDataEstipulada(obj.getDataEstipulada());
	}
}
