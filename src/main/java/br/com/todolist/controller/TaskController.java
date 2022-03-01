package br.com.todolist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.todolist.entity.Task;
import br.com.todolist.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	private TaskService service;
	 
	@PostMapping
	public ResponseEntity<Task> save(@RequestBody Task task) {
		Task taskSaved = service.save(task);
		return ResponseEntity.status(HttpStatus.CREATED).body(taskSaved);
	}
	
	@GetMapping
	public ResponseEntity<List<Task>> list() {
		return ResponseEntity.ok(service.list());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> listById(@PathVariable Long id) {
		Optional<Task> task = service.listById(id);
		return task.isPresent() ? ResponseEntity.ok(task.get()) : ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{userId}/done")
	public ResponseEntity<List<Task>> listDone(@PathVariable Long userId) {
		return ResponseEntity.ok(service.listByChecked(true, userId));
	}
	
	@GetMapping("/{userId}/todo")
	public ResponseEntity<List<Task>> listToDo(@PathVariable Long userId) {
		return ResponseEntity.ok(service.listByChecked(false, userId));
	}
	
}
