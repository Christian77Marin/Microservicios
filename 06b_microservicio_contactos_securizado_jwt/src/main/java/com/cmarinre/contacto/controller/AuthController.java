package com.cmarinre.contacto.controller;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmarinre.contacto.util.Constants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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
		String token = Jwts.builder()
				.setIssuedAt(new Date())// Fecha de creacion
				.setSubject(autentication.getName())//usuario
				.claim("authorities", autentication.getAuthorities().stream() //roles
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()))
				.setExpiration(new Date(System.currentTimeMillis() + Constants.TIEMPO_VIDA)) //fecha de caducidad
				.signWith(SignatureAlgorithm.HS512,  Constants.CLAVE) //clave y algoritmo para firma
				.compact(); //Generacion del token
		
		return token;
						
	
	}
	
	
}
