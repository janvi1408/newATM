package com.cg.banking.exception;

import java.net.http.HttpHeaders;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
	@ExceptionHandler(InvalidAccountId.class)
	public ResponseEntity<String> invalidId(InvalidAccountId e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(LessThanMinimum.class)
	public ResponseEntity<String> lessThanMinimum(LessThanMinimum e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidUserId.class)
	public ResponseEntity<String> ivalidUserId(InvalidUserId e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
	             Map<String, String> resp = new HashMap<> () ;
	             ex.getBindingResult().getAllErrors().forEach((error) ->{
	                 System.out.println(error.toString());
	                 String fieldName = ((FieldError) error).getField();
	                 String message = error.getDefaultMessage () ;
	                 resp.put (fieldName, message);
	             });

	return new ResponseEntity<Map<String, String>>(resp,HttpStatus.BAD_REQUEST);}
}
