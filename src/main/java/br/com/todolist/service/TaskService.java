package br.com.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.todolist.entity.Task;
import br.com.todolist.repository.TaskRepository;

@Service
public class TaskService  {

	@Autowired
	private TaskRepository repository;
	
	public Task save(Task task) {
		Task taskSaved = repository.save(task);
		return taskSaved;
	}
	
	public List<Task> list() {
		List<Task> list = repository.findAll();
		return list;
	}
	
	public Optional<Task> listById(Long id) {
		return repository.findById(id);
	}
	
	public List<Task> listByChecked(boolean checked, Long userId) {
		List<Task> list = repository.findByChecked(checked, userId);
		return list;
	}
	
}
