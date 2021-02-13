package com.amit.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.amit.app.model.User;
import com.amit.app.service.UserService;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootWebApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MockMvc mockMVC;
	
	@Test
	void getUserList() {
		List<User> userList= userService.getAllUsers();
		assertEquals("User list size should be 4", 4, userList.size());
	}
	
	@Test
	void getUsersViaRest() throws Exception {
		mockMVC.perform(MockMvcRequestBuilders.get("/users")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(4));
	}

	@Test
	void getUserByUserName() throws Exception {
		mockMVC.perform(MockMvcRequestBuilders.get("/users/{userId}", "user1"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("user1"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("First User"));
	}
}
