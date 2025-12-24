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

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	 // ✅ 1. VALIDATION ERRORS (@Valid)
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationErrors(
	            MethodArgumentNotValidException ex) {

	        Map<String, String> errors = new HashMap<>();

	        ex.getBindingResult()
	          .getFieldErrors()
	          .forEach(error ->
	              errors.put(error.getField(), error.getDefaultMessage())
	          );

	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
	
	
	
	// ✅ 2. RESOURCE NOT FOUND
	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourseNotFoundException ex){
		
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), 
				LocalDateTime.now());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		
	}
	
	// ✅ 3. DATABASE ERRORS
	@ExceptionHandler(DataBaseException.class)
    public ResponseEntity<ErrorResponse> handleDatabaseException(
            DataBaseException ex) {

		ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
	
	 // ✅ 4.  Duplicate ResourceEXCEPTION (ALWAYS KEEP AT BOTTOM)
    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse>handleDuplicate(DuplicateResourceException ex){
    	ErrorResponse error = new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
    	return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    	
    }

	
	
    // ✅ 5. FALLBACK EXCEPTION (ALWAYS KEEP AT BOTTOM)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(Exception ex){
		
		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Something went wrong",
				 LocalDateTime.now());
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	

}
