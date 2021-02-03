package com.amit.test;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.amit.controller.MessageController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringTestConfig.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMessageController {
	
	private MockMvc mockMVC;
	
	@Autowired
	private MessageController messageController;
	
	@Before
    public void init(){
		mockMVC = MockMvcBuilders.standaloneSetup(messageController).build();
    }
	
	@Test
	public void getMessages() throws Exception {		
		mockMVC.perform(MockMvcRequestBuilders.get("/messages")).andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));
	}
	
	@Test
	public void getMessageById() throws Exception {		
		mockMVC.perform(MockMvcRequestBuilders.get("/messages/{id}", 1)).andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath("$.author").value("author 1"));
	}
	
	@Test
	public void postMessage() throws Exception {	
		String jsonData= "{\"id\" : \"3\", \"author\" : \"author 3\", \"message\" : \"First message posted by author 3\", \"postedDate\" : \"21-01-2021\"}";
		mockMVC.perform(MockMvcRequestBuilders.post("/messages").contentType(MediaType.APPLICATION_JSON).content(jsonData)).andExpect(MockMvcResultMatchers.status().isCreated());
		mockMVC.perform(MockMvcRequestBuilders.get("/messages/{id}", 3)).andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(3))
		.andExpect(MockMvcResultMatchers.jsonPath("$.author").value("author 3"));
	}
}
