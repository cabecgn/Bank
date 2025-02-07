package com.bank.Bank.infrastructure.endpoint.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bank.Bank.infrastructure.endpoint.dto.ErrorResponse;

@ControllerAdvice
public class BankExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(CompanyExistException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ErrorResponse> CompanyExist(CompanyExistException companyExistException) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, companyExistException.getMessage()); 
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		
	}

}
