package com.bank.Bank.infrastructure.mappers;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.bank.Bank.domain.models.Company;
import com.bank.Bank.infrastructure.entities.CompanyEntity;

@Component()
public class CompanyMapper {

	public CompanyEntity toEntity(Company company) {
		if (Objects.isNull(company)) {
			return null;
		}

		return CompanyEntity.builder().id(company.getId()).dateAccession(company.getDateAccession())
				.cuit(company.getCuit()).companyName(company.getCompanyName()).build();
	}

	public Company toDomain(CompanyEntity companyEntity) {
		if (Objects.isNull(companyEntity)) {
			return null;
		}

		return Company.builder().id(companyEntity.getId()).dateAccession(companyEntity.getDateAccession())
				.companyName(companyEntity.getCompanyName()).cuit(companyEntity.getCuit()).build();
	}

}
