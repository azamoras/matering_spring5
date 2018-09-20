package com.mastering.spring.cap8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastering.spring.cap8.domain.Todo;
import com.mastering.spring.cap8.repository.TodoRepository;

@DataJpaTest 
@RunWith(SpringRunner.class)
public class TodoRepositoryTests {


	@Autowired
	private TodoRepository repository;
	
	

	@Test
	public void check_todo_count() throws Exception {

		assertEquals(3, repository.count());
	}
	
	@Test
	public void finOne() throws Exception {

		
		Optional<Todo> todo = repository.findById(101L);
		
		assertEquals("Todo Desc 1", todo.get().getDesc());
	}
	
	
	@Test
	public void exist() throws Exception {

		assertFalse(repository.existsById(105L));
		assertTrue(repository.existsById(101L));
	}
	
}
