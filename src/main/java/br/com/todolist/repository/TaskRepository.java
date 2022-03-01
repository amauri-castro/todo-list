package br.com.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.todolist.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	@Query(value = "SELECT * FROM tarefa where feito = :done and id_usuario = :userId", nativeQuery = true)
	public List<Task> findByChecked(boolean done, Long userId);
	public List<Task> findByCheckedAndName(boolean checked, String name);
}
