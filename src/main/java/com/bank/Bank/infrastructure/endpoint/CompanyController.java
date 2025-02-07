package com.bank.Bank.infrastructure.endpoint;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.Bank.application.services.CompanyService;
import com.bank.Bank.domain.models.Company;
import com.bank.Bank.infrastructure.endpoint.dto.CompanyDTO;
import com.bank.Bank.infrastructure.endpoint.error.CompanyExistException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

	@Autowired
	CompanyService service;

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UUID create(@Valid @RequestBody CompanyDTO dto) throws CompanyExistException {

		Company company = service.create(dto.getCuit(), dto.getCompanyName());

		return company.getId();
	}

	@GetMapping(value = "/companiesTransfersLastMonth", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Company> findCompaniesThatMadeTransfersLastMonth() {

		return service.findCompaniesThatMadeTransfersLastMonth();

	}

	@GetMapping(value = "/companiesAccessionLastMonth", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Company> findCompaniesThatAccessionLastMonth() {

		return service.findCompaniesThatAccessionLastMonth();

	}

}
