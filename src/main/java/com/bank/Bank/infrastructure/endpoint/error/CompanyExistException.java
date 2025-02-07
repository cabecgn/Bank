package com.bank.Bank.infrastructure.endpoint.error;

public class CompanyExistException extends Exception {

	private static final long serialVersionUID = 1028651137081825263L;
	
	public CompanyExistException(String msg) {
		super(msg);
	}

}
