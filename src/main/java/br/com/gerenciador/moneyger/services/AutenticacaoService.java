package br.com.gerenciador.moneyger.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gerenciador.moneyger.repositories.UserRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return repository.findByEmail(userName)
                .orElseThrow(() -> new UsernameNotFoundException("O Usuario com o email: " + userName + " não foi encontrado"));
    }
}
