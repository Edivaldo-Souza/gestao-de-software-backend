package com.edu.engenharia.gestordesoftare.api.filters;

import java.io.IOException;
import java.util.Collections;



import com.edu.engenharia.gestordesoftare.domain.entities.Usuario;
import com.edu.engenharia.gestordesoftare.domain.services.AuthenticationService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class LoginFilter extends AbstractAuthenticationProcessingFilter{
	public LoginFilter(String url,AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
				Usuario u = new ObjectMapper().readValue(request.getInputStream(),Usuario.class);
				return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
						u.getNome(),u.getSenha(),Collections.emptyList()));
		
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest req,HttpServletResponse res, FilterChain chain, Authentication auth)
	throws IOException, ServletException{
		AuthenticationService.addToken(res,auth.getName());
		res.setHeader("Access-Control-Expose-Headers", "Authorization");
	}
	
}
