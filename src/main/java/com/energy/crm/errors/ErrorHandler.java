package com.energy.crm.errors;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> entityNotFoundHandler(EntityNotFoundException entityNotFoundException) {
		return new ResponseEntity<String> (entityNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity validationErrorHandler(ConstraintViolationException ex) {
		
		List<String> errorList = new ArrayList<String>();
		Set<ConstraintViolation<?>> errors = ex.getConstraintViolations();
		for (ConstraintViolation<?> constraintViolation : errors) {
			errorList.add(  constraintViolation.getMessage()  );
			
		}
		
		return new ResponseEntity(errorList, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<String> alreadyExistHandler(EntityExistsException entityExistsException) {
		
		return new ResponseEntity<String>( entityExistsException.getMessage( ), HttpStatus.BAD_REQUEST  );
		
	}
	
	
	

}
