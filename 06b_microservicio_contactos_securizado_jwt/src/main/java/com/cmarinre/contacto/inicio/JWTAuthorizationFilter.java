package com.cmarinre.contacto.inicio;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.cmarinre.contacto.util.Constants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter{

	public JWTAuthorizationFilter(AuthenticationManager auth) {
		super(auth);
	}
	
	
	protected void doFilterInternal(HttpServletRequest req,HttpServletResponse res, FilterChain chain) throws IOException, ServletException{
		String header = req.getHeader(Constants.CLAVE);
		if(header == null || !header.startsWith(Constants.PREFIJO_TOKEN)) {
			chain.doFilter(req, res);
			return;
		}
		
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
	}
	
	
	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req) {
		String token = req.getHeader(Constants.ENCABEZADO);
		if(token != null) {
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(Constants.CLAVE).build()
					.parseClaimsJws(token.replace(Constants.PREFIJO_TOKEN, ""))
					.getBody();
			String user = claims.getSubject();
			List<String> authorities = (List<String>) claims.get("authorities");
			
			if(user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, authorities.stream()
						.map(SimpleGrantedAuthority::new)
						.collect(Collectors.toList()));
			}
			return null;
		}
		return null;
	}
	
	
}
