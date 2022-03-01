package br.com.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.todolist.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
}
