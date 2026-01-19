package com.opd_management.security;

import java.io.IOException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opd_management.responce.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request,
						HttpServletResponse response,
						AuthenticationException authException)
				throws IOException, ServletException {
		
		
		ErrorResponse error = new ErrorResponse(
				HttpServletResponse.SC_UNAUTHORIZED,
				"Unauthorized: Invalid or missing JWT token"
				);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        new ObjectMapper().writeValue(response.getOutputStream(), error);
	}

}
