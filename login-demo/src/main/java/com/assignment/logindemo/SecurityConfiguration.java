package com.assignment.logindemo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.assignment.logindemo.repository.UserRepository;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {

	@Autowired
	DataSource dataSource;

	@Autowired
	UserRepository users;

	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {

		http.csrf().disable();

		return http.authorizeExchange().anyExchange().permitAll().and().build();

	}

	@Bean
	public MapReactiveUserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("admin").password("root").roles("USER").build();
		return new MapReactiveUserDetailsService(user);
	}

	/*
	 * @Bean public DataSource dataSource() {
	 * 
	 * EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	 * EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL) // .H2 or
	 * .DERBY .addScript("db/sql/create.sql") .addScript("db/sql/insert.sql")
	 * .continueOnError(true) .build(); return db; }
	 * 
	 * @Bean public JdbcTemplate getJdbcTemplate() { return new
	 * JdbcTemplate(dataSource); }
	 * 
	 * @Bean public ReactiveUserDetailsService userDetailsService(UserRepository
	 * users) { return (username) ->
	 * users.findByUsername(username).cast(UserDetails.class); }
	 */
}
