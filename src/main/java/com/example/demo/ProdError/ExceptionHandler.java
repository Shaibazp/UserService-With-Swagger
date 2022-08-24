package com.example.demo.ProdError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler 
{
	@org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFound.class)
	public ResponseEntity<String> prodHandler(ProductNotFound notfound)
	{
		return new ResponseEntity<String>(notfound.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
