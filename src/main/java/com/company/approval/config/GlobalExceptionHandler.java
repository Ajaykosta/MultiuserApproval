package com.company.approval.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.approval.exceptions.ResourceNotFoundException;
import com.company.approval.exceptions.UnauthorizedActionException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UnauthorizedActionException.class)
	public ResponseEntity<String> handleUnauthorizedAction(UnauthorizedActionException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception ex) {
		return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
