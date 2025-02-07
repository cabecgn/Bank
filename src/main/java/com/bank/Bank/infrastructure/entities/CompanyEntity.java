package com.bank.Bank.infrastructure.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {

	@Id
	@GeneratedValue(generator = "uuid2")
	UUID id;

	@NotNull
	private String cuit;

	@NotNull
	private String companyName;

	@NotNull
	private LocalDate dateAccession;

}
