package com.opd_management.security;

import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opd_management.responce.ErrorResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends  OncePerRequestFilter{

	@Autowired
	private JwtUtil jwtUtil;
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response, 
									FilterChain filterChain)
	
			throws ServletException, IOException {
		
		try {
			
			String authHeader = request.getHeader("Authorization");
			
			// ✅ If token missing → skip
			if(authHeader == null || !authHeader.startsWith("Bearer ")) {
				
				filterChain.doFilter(request, response);
				
				return;
			}
			
			String token = authHeader.substring(7);
			
			if(jwtUtil.isValid(token)) {
				
				// 🔐 Extract data from JWT
				String email = jwtUtil.extractEmail(token);
				String role = jwtUtil.extractRole(token);
				
				// 🔑 Convert ROLE to Authority
				SimpleGrantedAuthority authority = new 
						SimpleGrantedAuthority("ROLE_" + role);
				
				UsernamePasswordAuthenticationToken auth =
						new UsernamePasswordAuthenticationToken(
								email,
								null,
								List.of(authority)
								 );
				
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
			
			filterChain.doFilter(request, response);
			
			
		}
		catch (ExpiredJwtException e) {
			sendError(response, "JWT token expired");
		} 
		catch (MalformedJwtException e) {
			sendError(response, "Invalid Jwt token");
		}
		catch (SignatureException e) {
			sendError(response, "JWT signature invalid");
		}
//		catch (Exception ex) {
//          sendError(response, "JWT authentication failed");
//      }
	}
	
	// 🔴 Error Response Method
	private void sendError(HttpServletResponse response, String message) throws  IOException {
		
		
		
		 ErrorResponse error = new ErrorResponse(
				 HttpServletResponse.SC_UNAUTHORIZED,
				 message);
		 
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setContentType("application/json");
		
		new ObjectMapper().writeValue(response.getOutputStream(), error);
	}
	
	

}
