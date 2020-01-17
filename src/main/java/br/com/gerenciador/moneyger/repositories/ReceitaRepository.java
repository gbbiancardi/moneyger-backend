package br.com.gerenciador.moneyger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciador.moneyger.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{

}
