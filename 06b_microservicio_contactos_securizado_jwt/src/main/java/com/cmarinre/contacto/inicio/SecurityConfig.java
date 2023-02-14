package com.cmarinre.contacto.inicio;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.cmarinre.contacto.util.Constants;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	AuthenticationManager auth;
	
	@Bean
	public InMemoryUserDetailsManager detailsManager() throws Exception{
		List<UserDetails> users = List.of(
				
				User.withUsername("user1")
				.password("{noop}user1")
				.authorities("USERS")
				.build(),
				User.withUsername("admin")
				.password("{noop}admin")
				.authorities("USERS","ADMIN")
				.build()
				);
		
		return new InMemoryUserDetailsManager(users);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeHttpRequests().
		requestMatchers(HttpMethod.POST,"/contactos").hasAuthority("ADMIN").
		requestMatchers("/contactos").authenticated()
		.and()
		.addFilter((new JWTAuthorizationFilter(auth)));
		
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration authConfig) throws Exception{
		
		auth = authConfig.getAuthenticationManager();
		
		return auth;
	}
	
}
