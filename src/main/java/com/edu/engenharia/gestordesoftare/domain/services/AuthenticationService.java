package com.edu.engenharia.gestordesoftare.domain.services;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.util.Collections.emptyList;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationService {
	static final long EXPIRATIONTIME = 864_000_00;
	static final String SIGNINKEY = "OmFgKey";
	static final String PREFIX = "bearer";
	
	static public void addToken(HttpServletResponse res, String nome) {
		String JwtToken = Jwts.builder().setSubject(nome)
				.setExpiration(new Date(System.currentTimeMillis()+EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SIGNINKEY)
				.compact();
		res.addHeader("Authorization", PREFIX+" "+JwtToken);
		res.addHeader("Acess-Control-Expose-Headers","Authorization");
	}
	
	static public Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token!=null) {
			String nome = Jwts.parser()
					.setSigningKey(SIGNINKEY)
					.parseClaimsJws(token.replace(PREFIX, ""))
					.getBody().getSubject();
			if(nome!=null) {
				return new UsernamePasswordAuthenticationToken(nome,null,emptyList());
			}
		}
		return null;
	}
}
