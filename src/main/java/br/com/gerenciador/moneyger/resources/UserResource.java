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

import br.com.gerenciador.moneyger.model.User;
import br.com.gerenciador.moneyger.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

//	@CrossOrigin
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<User> findById(@PathVariable Long id) {
//		User obj = service.findById(id);
//		return ResponseEntity.ok().body(obj);
//	}

//	@CrossOrigin
//	@GetMapping(value = "/{email}")
//	public ResponseEntity<User> findByEmail(@PathVariable String email) {
//		User obj = service.findByEmail(email);
//		return ResponseEntity.ok().body(obj);
//	}

	@CrossOrigin
	@GetMapping(value = "/{email}/{senha}")
	public ResponseEntity<User> login(@PathVariable String email, @PathVariable String senha) throws Exception {
		User obj = service.login(email, senha);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) throws Exception {
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
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
