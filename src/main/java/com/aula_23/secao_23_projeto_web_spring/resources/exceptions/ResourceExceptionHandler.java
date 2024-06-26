package com.aula_23.secao_23_projeto_web_spring.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.aula_23.secao_23_projeto_web_spring.services.exceptions.DataBaseException;
import com.aula_23.secao_23_projeto_web_spring.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

/*classe responsavel por tratar manual os erros*/
/*@ControllerAdvice intercepta as execeções para que o objeto possa 
 * Realizar as possiveis tratamento*/
@ControllerAdvice
public class ResourceExceptionHandler {
	/*Notação diz que o metodo inteceptará qualquer execação do tipo ResourceNotFoundException
	 * Realizará o tratamento implementado no corpo do metodo */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;//Error 404
		StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> database(DataBaseException e,HttpServletRequest request){
		String error = "Data Base Error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
