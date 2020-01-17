package br.com.gerenciador.moneyger.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciador.moneyger.model.Objetivo;
import br.com.gerenciador.moneyger.services.ObjetivoService;

@RestController
@RequestMapping(value = "/objetivo")
public class ObjetivoResource {

	@Autowired
	private ObjetivoService service;
	
	@GetMapping
	public ResponseEntity<List<Objetivo>> findAll() {
		List<Objetivo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Objetivo> findById(@PathVariable Long id) {
		Objetivo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
