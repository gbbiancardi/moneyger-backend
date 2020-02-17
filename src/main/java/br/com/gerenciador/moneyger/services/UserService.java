package br.com.gerenciador.moneyger.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.gerenciador.moneyger.model.User;
import br.com.gerenciador.moneyger.repositories.UserRepository;
import br.com.gerenciador.moneyger.services.exceptions.DatabaseException;
import br.com.gerenciador.moneyger.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

//	public User findById(Long id) {
//		Optional<User> obj = repository.findById(id);
//		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
//	}

	public User findByEmail(String email) {
		Optional<User> user = repository.findByEmail(email);
		return user.orElseThrow(() -> new ResourceNotFoundException(email));
	}

	private boolean isEmailValid(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	public User insert(User obj) throws Exception {
		BCryptPasswordEncoder encrypt = new BCryptPasswordEncoder();
		String senha = encrypt.encode(obj.getPassword());
		obj.setSenha(senha);

		if (repository.findByEmail(obj.getEmail()) != null && isEmailValid(obj.getEmail())
				&& !repository.findByEmail(obj.getEmail()).isPresent()) {
			return repository.save(obj);
		} else {
			throw new Exception("Usuário inválido!");
		}
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

	public User update(Long id, User obj) {
		try {
			User entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
	}
}
