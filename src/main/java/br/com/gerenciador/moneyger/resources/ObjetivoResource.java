package br.com.gerenciador.moneyger.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gerenciador.moneyger.model.Objetivo;
import br.com.gerenciador.moneyger.services.ObjetivoService;

@RestController
@RequestMapping(value = "/objetivos")
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
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Objetivo> insert(@RequestBody Objetivo obj) throws Exception {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	@PutMapping(value = "/{id}")
	public ResponseEntity<Objetivo> update(@PathVariable Long id, @RequestBody Objetivo obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
