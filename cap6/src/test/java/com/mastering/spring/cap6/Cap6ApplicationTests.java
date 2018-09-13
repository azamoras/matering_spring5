package com.mastering.spring.cap6;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mastering.spring.cap6.rest.BasicController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BasicController.class, secure = false)
public class Cap6ApplicationTests {


	@Autowired
	private MockMvc mvc;
	
	

	@Test
	public void welcome() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/welcome").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	

}
