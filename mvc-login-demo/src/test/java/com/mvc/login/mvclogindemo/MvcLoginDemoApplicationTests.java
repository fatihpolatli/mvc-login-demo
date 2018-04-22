package com.mvc.login.mvclogindemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.mvc.login.config.MvcLoginDemoApplication;
import com.mvc.login.controller.RegistrationController;
import com.mvc.login.dto.UserDto;
import com.mvc.login.entity.User;
import com.mvc.login.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = { MvcLoginDemoApplication.class })
@AutoConfigureMockMvc
public class MvcLoginDemoApplicationTests {

	@Autowired
	RegistrationController registrationController;

	@Autowired
	private MockMvc mockMvc;

	private final String BASE_URI = "http://localhost:8080/";

	@Test
	public void contextLoads() {

		assertThat(registrationController).isNotNull();
	}

	@Autowired
	IUserService userService;

	@Test
	public void userRegistrationTest() throws Exception {

		UserDto accountDto = new UserDto();
		accountDto.setFirstName("testUser");
		accountDto.setPassword("test");
		accountDto.setEmail("test@test.com");

		userService.registerNewUserAccount(accountDto);

		User user = userService.findByUserName(accountDto.getFirstName());
		assertEquals(accountDto.getFirstName(), user.getUsername());
	}

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/restful/test")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("this is test")));
	}
	
	

	@Test
	public void givenDuplicateEmail_thenBadRequest() throws Exception {
		
		getResponseForPasswordOk("test@test.com");
		
		getResponseForPassword("test@test.com");

		
	}

	private void getResponseForPassword(String email) throws Exception {
		final Map<String, String> param = new HashMap<String, String>();
		final String randomName = UUID.randomUUID().toString();
		param.put("firstName", randomName);
		param.put("lastName", "Doe");
		param.put("email", email);
		param.put("password", "12345");
		
		this.mockMvc.perform(post("/user/registration",param)).andDo(print()).andExpect(status().isBadRequest());
		
		
	}
	
	private void getResponseForPasswordOk(String email) throws Exception {
		final Map<String, String> param = new HashMap<String, String>();
		final String randomName = UUID.randomUUID().toString();
		param.put("firstName", randomName);
		param.put("lastName", "Doe");
		param.put("email", email);
		param.put("password", "12345");
		
		this.mockMvc.perform(post("/user/registration",param)).andDo(print()).andExpect(status().isOk());
		
	}

}
