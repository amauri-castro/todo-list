package br.com.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
