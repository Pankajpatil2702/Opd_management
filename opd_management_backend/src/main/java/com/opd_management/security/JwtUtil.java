package com.opd_management.security;

import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Component;
import com.opd_management.entities.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/** - Utility class responsible for:
 *  - Generating JWT tokens
 *  - Validating JWT tokens
 *  - Extracting data (email, role) from JWT tokens
 */
@Component
public class JwtUtil {
	
	/**
     * Secret key used to sign JWT tokens.
     * Must be at least 32 characters for HS256 algorithm.
     */
	private final String SECRET = "ThisIsASecretKeyForJwtTokenGenration12345";  // 32+ chars
	
	/**
     * Token expiration time
     * Here: 24 hours (1 day)
     */
	private final long EXPIRATION = 1000 * 60 * 60 * 24; // 1 day
	
	/**
     * Creates and returns the signing key
     * using HMAC SHA-256 algorithm.
     */
	private Key getSigningKey() {
		
		return Keys.hmacShaKeyFor(SECRET.getBytes());
	}
	
	/**
     * Generate JWT token
     *
     * @param email User email (stored as subject)
     * @param role  User role (stored as custom claim)
     * @return Signed JWT token
     */
	public String generateToken(String email, Role role) {
		
		return Jwts.builder()
				// Subject usually represents the username/email
				.setSubject(email) // usually email or user name
				// Custom claim to store user role
				.claim("role", role)
				// Token creation time
				.setIssuedAt(new Date())  
				// Token expiration time
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
				// Sign token using secret key and algorithm
				.signWith(getSigningKey(), SignatureAlgorithm.HS256)
				// Build and return compact JWT string
				.compact();
	}
	
	
	/**
     * Extract email (subject) from JWT token
     *
     * @param token JWT token
     * @return email stored inside token
     */
	public String extractEmail(String token) {               
		
		// getSubject() returns the value set using setSubject()
		return parseToken(token).getBody().getSubject();    
		
	}
	
	
	/**
     * Validate JWT token
     * Checks:
     *  - Signature
     *  - Expiration
     *  - Token format
     *
     * @param token JWT token
     * @return true if token is valid, false otherwise
     */
	public boolean isValid(String token) {
		
		try {
			// Parsing itself validates the token
			parseToken(token);
			
			return true;
		}
		catch(Exception e) {
			
			return false;
		}
	}
	
	
	/**
     * Extract role from JWT token
     *
     * @param token JWT token 
     * @return role stored inside token
     */
	public String extractRole(String token) {
		
		return parseToken(token).getBody().get("role", String.class);
		
	}
	
	 /**
     * Parse and validate JWT token
     * Returns the claims if token is valid
     */
	private Jws<Claims>  parseToken(String token){
		
		return Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.build()
				.parseClaimsJws(token);
	}

}
