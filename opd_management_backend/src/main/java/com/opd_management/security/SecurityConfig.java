package com.opd_management.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * This class configures spring security for the application.
 * It defines authentication rules , JWT filter, and security behavior.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	
	/**
     * Custom JWT authentication filter
     * Used to validate JWT token on every request
     */
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
		
	/**
     * Custom entry point to handle unauthorized access
     * (e.g. invalid or missing JWT)
     */
	@Autowired
	private JwtAuthEntryPoint jwtAuthEntryPoint;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		 http
		 	.csrf(csrf -> csrf.disable())
		 	.exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthEntryPoint))
		 	.authorizeHttpRequests(auth -> auth
		 			.requestMatchers("/doctors/regsiter",
		 					"/auth/login/doctor",
		 					"/auth/login/admin",
		 					"/auth/login/reception",
		 					"/api/reception/regsiter").permitAll()
		 			.anyRequest().authenticated()
		 			)
		 	.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
		 http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

	
	    return http.build();
	}
	

}
