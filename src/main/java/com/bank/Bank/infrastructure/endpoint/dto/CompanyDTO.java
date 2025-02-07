package com.bank.Bank.infrastructure.endpoint.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDTO {

	@NotBlank(message = "el cuit no puede estar vacío")
	private String cuit;
	@NotBlank(message = "el nombre no puede estar vacío")
	private String companyName;

}
