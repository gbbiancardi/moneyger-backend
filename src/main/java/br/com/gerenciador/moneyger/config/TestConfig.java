package br.com.gerenciador.moneyger.config;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.gerenciador.moneyger.model.Despesa;
import br.com.gerenciador.moneyger.model.Objetivo;
import br.com.gerenciador.moneyger.model.Receita;
import br.com.gerenciador.moneyger.model.User;
import br.com.gerenciador.moneyger.model.enums.StatusObjetivo;
import br.com.gerenciador.moneyger.model.enums.TipoDespesa;
import br.com.gerenciador.moneyger.model.enums.TipoObjetivo;
import br.com.gerenciador.moneyger.model.enums.TipoReceita;
import br.com.gerenciador.moneyger.repositories.DespesaRepository;
import br.com.gerenciador.moneyger.repositories.ObjetivoRepository;
import br.com.gerenciador.moneyger.repositories.ReceitaRepository;
import br.com.gerenciador.moneyger.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private ObjetivoRepository objetivoRepository;
//
//	@Autowired
//	private DespesaRepository despesaRepository;
//
//	@Autowired
//	private ReceitaRepository receitaRepository;

	@Override
	public void run(String... args) throws Exception {

//		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "123456");
//		User u2 = new User(null, "Alex Green", "alex@gmail.com", "123456");
//
//		userRepository.saveAll(Arrays.asList(u1, u2));
//
//		Objetivo o1 = new Objetivo(null, "Viagem", BigDecimal.valueOf(18000), Instant.now(),
//				Instant.parse("2019-06-20T19:53:07Z"), TipoObjetivo.TURISMO, StatusObjetivo.CAMINHANDO, u1);
//		Objetivo o2 = new Objetivo(null, "Casa Própria", BigDecimal.valueOf(250000), Instant.now(),
//				Instant.parse("2019-06-20T19:53:07Z"), TipoObjetivo.IMOVEL, StatusObjetivo.AFASTANDO, u2);
//
//		objetivoRepository.saveAll(Arrays.asList(o1, o2));
//
//		Despesa d1 = new Despesa(null, "Conta de luz", BigDecimal.valueOf(200), Instant.now(), TipoDespesa.CONTA, u1);
//		Despesa d2 = new Despesa(null, "Conta de água", BigDecimal.valueOf(80), Instant.now(), TipoDespesa.CONTA, u2);
//
//		despesaRepository.saveAll(Arrays.asList(d1, d2));
//
//		Receita r1 = new Receita(null, "Salário", BigDecimal.valueOf(2200), Instant.now(), TipoReceita.SALARIO, u1);
//		Receita r2 = new Receita(null, "Transferência", BigDecimal.valueOf(500), Instant.now(),
//				TipoReceita.TRANSFERENCIA, u2);
//
//		receitaRepository.saveAll(Arrays.asList(r1, r2));
	}
}
