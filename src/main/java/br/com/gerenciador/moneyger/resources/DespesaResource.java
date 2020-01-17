package br.com.gerenciador.moneyger.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciador.moneyger.model.Despesa;
import br.com.gerenciador.moneyger.services.DespesaService;

@RestController
@RequestMapping(value = "/despesa")
public class DespesaResource {

	@Autowired
	private DespesaService service;
	
	@GetMapping
	public ResponseEntity<List<Despesa>> findAll() {
		List<Despesa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Despesa> findById(@PathVariable Long id) {
		Despesa obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
