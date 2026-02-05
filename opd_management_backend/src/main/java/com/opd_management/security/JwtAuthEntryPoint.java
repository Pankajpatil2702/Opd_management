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


/**
 * This class handles unauthorized access attempts.
 * It is triggered when a user tries to access
 * a protected APL without a valid JWT token
 */

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint{   /// only for missing token show error

	/**
	 * This method is called is automatically by spring security 
	 * when authentication fails or when JWT token is missing/invalid.
	 */
	@Override
	public void commence(HttpServletRequest request,
						HttpServletResponse response,
						AuthenticationException authException)
				throws IOException, ServletException {
		
		// 1. create a custom error response
		ErrorResponse error = new ErrorResponse(
				HttpServletResponse.SC_UNAUTHORIZED,
				"Unauthorized: Invalid or missing JWT token"
				);
		// 2. set HTTP status as 401 (unauthorized)
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		// 3. set response content type as JSON
        response.setContentType("application/json");

        // 4. Write error response to HTTP output stream
        new ObjectMapper().writeValue(response.getOutputStream(), error);
	}

}
