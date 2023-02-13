package com.cmarinre.contacto.controller;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;

@RestController
public class AuthController {

	AuthenticationManager authManager;
	
	public AuthController(AuthenticationManager authManager) {
		this.authManager = authManager;
	}
	
	@PostMapping("login")
	public String login(@RequestParam("user")String user, @RequestParam("pwd") String pwd) {
		Authentication autentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user, pwd));
		
		if(autentication.isAuthenticated()) {
			return getToken(autentication);
		}else {
			return "no autenticado";
		}
	}
	
	private String getToken(Authentication autentication) {
		String token = Jwts.builder().
				setIssuedAt(new Date()).setSubject(autentication.getName())
				.claim(null, autentication)
	}
	
	
}
