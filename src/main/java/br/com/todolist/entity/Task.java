package br.com.todolist.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tarefa")
public class Task implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tarefa")
	private Long id;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "feito")
	private boolean checked;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private User user;
	
}
