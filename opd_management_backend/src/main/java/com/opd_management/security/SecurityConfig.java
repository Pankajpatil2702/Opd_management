package com.opd_management.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		 http
		 
		 	// Disable CSRF protection (used when have JWT / REST APIs)
	        .csrf(csrf -> csrf.disable())
	        
	        // Configuration authorization rules for HTTP requests
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/auth/login",
	            		"/doctor/regsiter").permitAll()
	            .anyRequest().authenticated()
	        )
	        
	        // disable spring Security default login form
	        .formLogin(form -> form.disable())
	        
	        // disable HTTP Basic authentication (browser popup login )
	        .httpBasic(basic -> basic.disable());
		 
		// build and return the security filter chain 
	    return http.build();
	}
	
	


}
