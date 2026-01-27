package com.opd_management.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

		@Autowired
		private JwtAuthenticationFilter jwtAuthenticationFilter;
		
		@Autowired
		private JwtAuthEntryPoint jwtAuthEntryPoint;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		 http
		 
		 	.csrf(csrf -> csrf.disable())
		 	.exceptionHandling(ex -> 
		 	ex.authenticationEntryPoint(jwtAuthEntryPoint)
		 	)
		 	
		 	.authorizeHttpRequests(auth -> auth
		 			.requestMatchers("/doctors/regsiter",
		 					"/auth/login/doctor",
		 					"/auth/login/admin",
		 					"/auth/login/reception").permitAll()
		 			.anyRequest().authenticated()
		 			)
		 	.sessionManagement(session -> 
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );
		 
		 http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

		// build and return the security filter chain 
	    return http.build();
	}
	
	


}
