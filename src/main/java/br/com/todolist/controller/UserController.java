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

import br.com.todolist.entity.User;
import br.com.todolist.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user) {
		User userSaved = userService.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> list() {
		return ResponseEntity.ok(userService.list());
	}
}
