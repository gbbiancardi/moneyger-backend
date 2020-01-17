package br.com.gerenciador.moneyger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciador.moneyger.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

}
