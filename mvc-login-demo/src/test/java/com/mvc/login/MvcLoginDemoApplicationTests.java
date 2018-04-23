package com.mvc.login;
/*package com.mvc.login.mvclogindemo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mvc.login.entity.User;
import com.mvc.login.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class MvcLoginDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Configuration
	@ComponentScan("com.mvc.login")
	public static class SpringConfig {

	}

	@Autowired
	IUserService userService;

	@Test
	@WithUserDetails(value = "john", userDetailsServiceBeanName = "userDetailService")
	public void whenJohn_callLoadUserDetail_thenOK() {
		User user = userService.findByUserName("fatih1234");
		assertEquals("fatih1234", user.getUsername());
	}

}
*/