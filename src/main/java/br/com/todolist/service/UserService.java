package br.com.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todolist.entity.User;
import br.com.todolist.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User save(User user) {
		return repository.save(user);
	}
	
	public List<User> list(){
		return repository.findAll();
	}
}
