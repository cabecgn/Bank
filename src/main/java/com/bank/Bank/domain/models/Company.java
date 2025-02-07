package com.bank.Bank.domain.models;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

	private UUID id;
	private String cuit;
	private String companyName;
	private LocalDate dateAccession;

}
