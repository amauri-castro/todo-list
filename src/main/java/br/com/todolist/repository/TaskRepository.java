package br.com.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.todolist.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
