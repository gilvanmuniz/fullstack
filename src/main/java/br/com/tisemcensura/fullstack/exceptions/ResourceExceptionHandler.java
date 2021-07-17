package br.com.tisemcensura.fullstack.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandarError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Excetion Not Found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = e.getMessage();
		StandarError err = new StandarError(Instant.now(), status.value(), error, message, request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
