package com.tutorial.crud.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtTokenFilter extends OncePerRequestFilter{
	
	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	private final String REPLACEMENT = "";
	
	private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
	
	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String token = getToken(req);
			if(token != null && jwtProvider.validateToken(token)) {
				String nombreUsuario = jwtProvider.getNombreusuarioFromToken(token);
				UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		} catch (Exception e) {
			logger.error("FAIL EN EL METODO DO FILTER");
		}
		filterChain.doFilter(req, res);
	}

	private String getToken (HttpServletRequest request) {
		String header = request.getHeader(HEADER);
		if(header != null && header.startsWith("Bearer"))
			return header.replace(PREFIX, REPLACEMENT);
		return null;
	}
}
