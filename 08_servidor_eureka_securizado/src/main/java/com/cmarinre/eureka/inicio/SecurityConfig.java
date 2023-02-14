package com.cmarinre.eureka.inicio;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();//desactivacion de proteccion entre dominios
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}
	
	public void condigure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("admin").password("{noop}admin").roles("ADMIN");
		
	}

	
}
