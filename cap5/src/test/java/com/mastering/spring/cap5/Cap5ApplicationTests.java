package com.mastering.spring.cap5;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mastering.spring.cap5.rest.BasicController;

@RunWith(SpringRunner.class)
@WebMvcTest(BasicController.class)
public class Cap5ApplicationTests {


	@Autowired
	private MockMvc mvc;
	
	

	@Test
	public void welcome() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/welcome").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	

}
