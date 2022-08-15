package com.luizstocco.todo.resources;

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

import java.net.URI;
import java.util.List;
import com.luizstocco.todo.domain.Todo;
import com.luizstocco.todo.services.TodoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/todos")
public class TodoResource {

	@Autowired
	private TodoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Integer id) {
		Todo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/open")
	public ResponseEntity<List<Todo>> listOpen() {
		List<Todo> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/close")
	public ResponseEntity<List<Todo>> listClose() {
		List<Todo> list = service.findAllClose();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping
	public ResponseEntity<List<Todo>> listAll() {
		List<Todo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@PostMapping
	public ResponseEntity<Todo> create(@RequestBody Todo obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@DeleteMapping (value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Todo> uptade (@PathVariable Integer id,@RequestBody Todo obj) {
		Todo newObj = service.uptade(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
}
