package com.mastering.spring.cap8.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mastering.spring.cap8.domain.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todoCount = 3;

	static {
		todos.add(new Todo(1, "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "Learn Structs", new Date(), false));
		todos.add(new Todo(3, "Learn Hibernate", new Date(), false));
	}

	public  List<Todo>  retrieveTodos(String  user)  {   
		List<Todo>  filteredTodos  =  new  ArrayList<Todo>();     
		for  (Todo  todo  :  todos)  {            
			if (todo.getUser().equals(user))       
				filteredTodos.add(todo);      
		}          
		return  filteredTodos;          
	}

	public  Todo  addTodo(String  name,  String  desc, Date  targetDate,  boolean  isDone)  {      
		Todo  todo  =  new  Todo(
				++todoCount,   desc,  targetDate,  isDone);  
		todos.add(todo);  
		return  todo;
	}

	public  Todo  retrieveTodo(int  id)  {     
		for  (Todo  todo  :  todos)  {   
			if (todo.getId() ==  id)       
				return  todo;        
		}         
		return  null;      
	}      


}
