package com.bank.Bank.infrastructure.endpoint.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
	
	private HttpStatus status;
	private String error;

}
