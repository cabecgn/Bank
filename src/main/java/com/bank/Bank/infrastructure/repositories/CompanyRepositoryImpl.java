package com.bank.Bank.infrastructure.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Bank.application.repository.CompanyRepository;
import com.bank.Bank.application.repository.springdatajpa.CompanySpringRepository;
import com.bank.Bank.domain.models.Company;
import com.bank.Bank.infrastructure.entities.CompanyEntity;
import com.bank.Bank.infrastructure.mappers.CompanyMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyRepository {

	@Autowired
	private CompanySpringRepository repository;
	@Autowired
	private CompanyMapper mapper;

	@Override
	public Company saveCompany(Company company) {
		CompanyEntity companyEntity = repository.save(mapper.toEntity(company));
		return mapper.toDomain(companyEntity);
	}

	@Override
	public Optional<Company> findById(UUID id) {
		Optional<CompanyEntity> companyEntity = repository.findById(id);
		if (companyEntity.isEmpty()) {
			return Optional.empty();
		}
		return companyEntity.map(mapper::toDomain);
	}

	public List<Company> findCompaniesWithTransfersBetweenDates(LocalDateTime start, LocalDateTime end) {

		return repository.findCompaniesWithTransfersBetweenDates(start, end).stream().map(mapper::toDomain)
				.collect(Collectors.toList());
	}

	public List<Company> findCompaniesThatAccessionBetweenDates(LocalDate start, LocalDate end) {

		return repository.findCompaniesThatAccessionBetweenDates(start, end).stream().map(mapper::toDomain)
				.collect(Collectors.toList());

	}

	@Override
	public Optional<Company> findByCuit(String cuit) {
		CompanyEntity companyEntity = repository.findByCuit(cuit);
		
		if (Objects.isNull(companyEntity)) {
			return Optional.empty();
		}
		return Optional.of(mapper.toDomain(companyEntity));
	}

}
