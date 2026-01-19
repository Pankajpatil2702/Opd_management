package com.opd_management.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.opd_management.responce.ErrorResponse;

//Global exception handler class to handle exceptions across the whole application
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	 // ✅ 1. VALIDATION ERRORS (@Valid)
	 @ExceptionHandler(MethodArgumentNotValidException.class)   // handle specific exception
	 public ResponseEntity<Map<String, String>> handleValidationErrors(
	            MethodArgumentNotValidException ex) {

		 // Map to store field name as key and validation message as value
	        Map<String, String> errors = new HashMap<>();
	        
	        // Get all validation errors from the exception
	        ex.getBindingResult()
	          .getFieldErrors()  // Fetch field-level validation errors
	          .forEach(error ->
	              errors.put(error.getField(), error.getDefaultMessage())  // Put field name and its corresponding error message into map
	          );
	        
	        // Return errors map with HTTP 400 (Bad Request) status
	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
	
	
	
	// ✅ 2. RESOURCE NOT FOUND
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourseNotFoundException ex){
		
		// Create a custom error response object
	    // It contains:
	    // 1. HTTP status code (404 - Not Found)
	    // 2. Error message coming from the exception
	    // 3. Timestamp when the error occurred
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage()
			);
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
	}
	
	// ✅ 3. DATABASE ERRORS
	@ExceptionHandler(DataBaseException.class)
    public ResponseEntity<ErrorResponse> handleDatabaseException(
            DataBaseException ex) {
		
		// Create a custom error response for database failures
	    // It contains:
	    // 1. HTTP status code (500 - Internal Server Error)
	    // 2. Error message describing the database issue
	    // 3. Timestamp when the error occurred
		ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage()     // Database error message
               	 // Error occurrence time
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
	
	 // ✅ 4.  Duplicate ResourceEXCEPTION (ALWAYS KEEP AT BOTTOM)
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse>handleDuplicate(DuplicateResourceException ex){
    	
    	 // Create a custom error response object
        // It contains:
        // 1. HTTP status code (409 - Conflict)
        // 2. Error message explaining the duplicate issue
        // 3. Timestamp when the error occurred
    	ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                ex.getMessage()
                     );
    	 // Return the error response to the client
    	return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    	
    }

	
	
    // ✅ 5. FALLBACK EXCEPTION (ALWAYS KEEP AT BOTTOM)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(Exception ex){
		
		// Create a generic error response to avoid exposing internal details
	    // It contains:
	    // 1. HTTP status code (500 - Internal Server Error)
	    // 2. A user-friendly error message
	    // 3. Timestamp when the error occurred
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Something went wrong"
				 );
		// Return generic error response with HTTP 500
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	

}