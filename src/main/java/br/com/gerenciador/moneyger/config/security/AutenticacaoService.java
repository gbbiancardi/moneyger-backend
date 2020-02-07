package br.com.gerenciador.moneyger.config.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gerenciador.moneyger.model.User;
import br.com.gerenciador.moneyger.repositories.UserRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> usuario = repository.findByEmail(username);
		
		if (usuario.isPresent()) {
			return usuario.get();
		}
		
		throw new UsernameNotFoundException("Dados invalidos!");
	}

}