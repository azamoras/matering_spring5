package com.mastering.spring.cap6.rest;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mastering.spring.cap6.domain.Todo;
import com.mastering.spring.cap6.exception.TodoNotFoundException;
import com.mastering.spring.cap6.service.TodoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping("/users/{name}/todos")
	@ApiOperation(value = "Retrive all todos for a user passing in his name", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Todo> retrieveTodos(@PathVariable String name) {

		return todoService.retrieveTodos(name);
	}
	@GetMapping("/users/{name}/todos/{id}")
	public Resource<Todo>  retrieveTodo(@PathVariable String name, @PathVariable int id) {
		Todo todo = todoService.retrieveTodo(id);
		if(todo == null) {
          throw new TodoNotFoundException("Todo Not Found");
		}
		
		Resource<Todo>  todoResource = new Resource<Todo>(todo);
		ControllerLinkBuilder linkTo = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveTodos(name));
		todoResource.add(linkTo.withRel("all"));

		return todoResource;

	}

	@PostMapping("/users/{name}/todos")
	public ResponseEntity<Todo> add(@PathVariable String name, @Valid @RequestBody Todo todo) {
		Todo createdTodo = todoService.addTodo(name, todo.getDesc(), todo.getTargetDate(), todo.isDone());
		if(createdTodo == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()

		.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

		return ResponseEntity.created(location).build();


	}

}
