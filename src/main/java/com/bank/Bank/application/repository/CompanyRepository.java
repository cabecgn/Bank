package com.bank.Bank.application.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.bank.Bank.domain.models.Company;

public interface CompanyRepository {

	public Company saveCompany(Company company);

	public Optional<Company> findById(UUID id);

	public List<Company> findCompaniesWithTransfersBetweenDates(LocalDateTime start, LocalDateTime end);

	public List<Company> findCompaniesThatAccessionBetweenDates(LocalDate start, LocalDate end);
	
	public Optional<Company> findByCuit(String cuit);

}
