package com.sy.restapi.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;


@RestControllerAdvice //it is a combination of @controllerAdvice and @ResponseBody
public class GlobalExceptionController {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<?> handleCustomerIdNotFoundException (CustomerNotFoundException exception, HttpServletRequest request)
	{
		ApiError apiError = new ApiError();
		apiError.setMessage(exception.getMessage());;
		apiError.setLocalDateTime(LocalDateTime.now());
		apiError.setEndpoint(request.getRequestURI());
		apiError.setHttpStatus(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(apiError, apiError.getHttpStatus());
	}

}
