package com.mastering.spring.cap8.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mastering.spring.cap8.domain.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long> {
	
	Iterable<Todo> findAll();
	long count();
	
    List<Todo>  findByTitleAndDesc(String  title,  String  description); 
    List<Todo>  findDistinctTodoByTitleOrDesc(String  title,String  description);   
    List<Todo>  findByTitleIgnoreCase(String  title);
    List<Todo>  findByTitleOrderByIdDesc(String  lastname);         
    List<Todo>  findByIsDoneTrue();

}
