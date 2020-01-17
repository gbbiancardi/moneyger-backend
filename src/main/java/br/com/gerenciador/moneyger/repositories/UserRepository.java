package br.com.gerenciador.moneyger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciador.moneyger.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
