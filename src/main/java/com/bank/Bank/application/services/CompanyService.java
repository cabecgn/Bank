package com.bank.Bank.application.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Bank.application.repository.CompanyRepository;
import com.bank.Bank.domain.models.Company;
import com.bank.Bank.infrastructure.endpoint.error.CompanyExistException;


@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository;

	public Company create(String cuit, String companyName) throws CompanyExistException {
		
		Optional<Company> optionalCompany = repository.findByCuit(cuit);
		
		if (optionalCompany.isPresent()) {
			throw new CompanyExistException("El cuit ya existe");
		}
		
		Company company = new Company();
		company.setCuit(cuit);
		company.setCompanyName(companyName);
		company.setDateAccession(LocalDate.now());

		return repository.saveCompany(company);

	}

	public List<Company> findCompaniesThatMadeTransfersLastMonth() {

		LocalDateTime end = LocalDateTime.now();
		LocalDateTime start = end.minusMonths(1);

		return repository.findCompaniesWithTransfersBetweenDates(start, end);
	}

	public List<Company> findCompaniesThatAccessionLastMonth() {

		LocalDate end = LocalDate.now();
		LocalDate start = end.minusMonths(1);

		return repository.findCompaniesThatAccessionBetweenDates(start, end);
	}
}
