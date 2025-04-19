package com.empdb.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object>handleEmployeeNotFoundException(EmployeeNotFoundException ex,WebRequest request)
	{
		Map<String,Object> body=new HashMap<>();
		body.put("message",ex.getMessage());
		return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object>handleGlobalException(Exception ex,WebRequest request)
	{
		Map<String,Object>body=new HashMap<>();
		body.put("message","An unexpected error occurred");
		return new ResponseEntity<>(body,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}