package com.bank.Bank.application.services;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import com.bank.Bank.application.repository.CompanyRepository;
import com.bank.Bank.domain.models.Company;
import com.bank.Bank.infrastructure.endpoint.error.CompanyExistException;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {
	
	@Mock
	CompanyRepository repository;
	
	@InjectMocks
	private CompanyService companyService;
	
	@Test
	public void testCreateOk() {
		
		String cuit = "1234567890";
		String companyName = "C. ACME";
		
		Company companyTest = new Company();
		companyTest.setCuit(cuit);
		companyTest.setCompanyName(companyName);
		
		Optional<Company> optionalCompany = Optional.empty();
		Mockito.when(this.repository.findByCuit(Mockito.any())).thenReturn(optionalCompany);
		Mockito.when(this.repository.saveCompany(Mockito.any())).thenReturn(companyTest);		
		
		try {
			Company company = companyService.create(cuit, companyName);
			Assert.isTrue(company.getCuit().equals(cuit), "cuit OK");
			Assert.isTrue(company.getCompanyName().equals(companyName), "Company Name OK");
			
		} catch (CompanyExistException e) {
			Assert.isTrue(false, "No tiene que existe Exception");
		}
		
		
	}
	
	@Test
	public void testCreateException() {
		
		String cuit = "1234567890";
		String companyName = "C. ACME";
		
		Company companyTest = new Company();
		companyTest.setCuit(cuit);
		companyTest.setCompanyName(companyName);
		
		Optional<Company> optionalCompany = Optional.of(companyTest);
		Mockito.when(this.repository.findByCuit(Mockito.any())).thenReturn(optionalCompany);
		
		try {
			companyService.create(cuit, companyName);
			Assert.isTrue(false, "Tiene que existe Exception");
		} catch (CompanyExistException e) {
			Assert.isTrue(true, "Exception Ok");
			
		}
		
		
	}

}
